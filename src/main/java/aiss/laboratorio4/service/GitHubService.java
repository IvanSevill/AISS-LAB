package aiss.laboratorio4.service;

import aiss.laboratorio4.model.Commit;
import aiss.laboratorio4.model.GitHubCommitDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static aiss.util.Util.getNextPageUrl;

@Service
public class GitHubService {
    RestTemplate restTemplate;

    @Value("${github.token}")
    private String token;

    @Value("${github.baseUri}")
    private String baseUri;

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubCommitDetails> findAllCommits(String owner, String repo) {
        GitHubCommitDetails[] commits = null;
        String uri = baseUri + owner + "/" + repo + "/commits";
        commits = restTemplate.getForObject(uri, GitHubCommitDetails[].class);
        return commits!=null ? Arrays.stream(commits).toList() : List.of();
    }

    public List<Commit> getAllCommitsWithToken(String owner, String repo) {
        String uri = baseUri + owner + "/" + repo + "/commits";
        HttpHeaders headers = new HttpHeaders();

        // Coloca el token en caso de que exista
        if (!Objects.equals(token, "")) {
            headers.set("Authorization", "Bearer " + token);
        }

        HttpEntity<String> request = new HttpEntity<>(null, headers);
        ResponseEntity<GitHubCommitDetails[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, GitHubCommitDetails[].class);
        GitHubCommitDetails[] commits = response.getBody();

        return Arrays.stream(commits)
                    .map(listCommit -> listCommit.getCommit())
                    .collect(Collectors.toList());
    }



    public List<Commit> getCommitsNPageToken(String owner, String repo,  String perPage, String untilPage){
        String uri = baseUri + owner + "/" + repo + "/commits?per_page=" + perPage + "&page=";
        HttpHeaders headers = new HttpHeaders();

        List<Commit> commits = new ArrayList<>();

        if (!Objects.equals(token, "")){
            headers.set("Authorization", "Bearer " + token);
        }

        HttpEntity<String> request = new HttpEntity<>(null, headers);

        for (int i = 1; i <= Integer.parseInt(untilPage); i++) {
            String localUri = uri + i;
            ResponseEntity<GitHubCommitDetails[]> response =
                    restTemplate.exchange(localUri, HttpMethod.GET, request, GitHubCommitDetails[].class);

            List<Commit> pageCommits = Arrays.stream(response.getBody())
                    .map(GitHubCommitDetails::getCommit)
                    .toList();

            System.out.println("---------> PAGE = " + i + " | URI = " + localUri + " | COMMITS = " + pageCommits.size());
            System.out.println(pageCommits + "\n");

            if (pageCommits.isEmpty()) {
                break;
            } else {
                commits.addAll(pageCommits);
            }
        }

        return commits;
    }

    public List<Commit> getAllCommitsPaginatedToken(String owner, String repo, String perPage) {
        String uri = baseUri + owner + "/" + repo + "/commits?per_page=" + perPage;

        HttpHeaders headers = new HttpHeaders();
        if (!Objects.equals(token, "")) {
            headers.set("Authorization", "Bearer " + token);
        }



        HttpEntity<String> request = new HttpEntity<>(null, headers);
        List<Commit> commits = new ArrayList<>();
        String nextPageUrl = uri;

        while (nextPageUrl != null) {
            ResponseEntity<GitHubCommitDetails[]> response = restTemplate.exchange(
                    nextPageUrl,
                    HttpMethod.GET,
                    request,
                    GitHubCommitDetails[].class
            );

            GitHubCommitDetails[] commitDetailsArray = response.getBody();
            if (commitDetailsArray != null) {
                List<Commit> pageCommits = Arrays.stream(commitDetailsArray)
                        .map(GitHubCommitDetails::getCommit)
                        .toList();
                commits.addAll(pageCommits);

                System.out.println("- Fetched page from: " + nextPageUrl + " | Commits: " + pageCommits.size());
            }

            nextPageUrl = getNextPageUrl(response.getHeaders());
        }

        return commits;
    }


}
