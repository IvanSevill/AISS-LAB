package aiss.laboratorio4.service;

import aiss.laboratorio4.model.GitHubCommitDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    RestTemplate restTemplate;

    @Value("https://api.github.com/repos/")
    private String baseUri;

    @Autowired
    public CommitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubCommitDetails> findAllCommits(String owner, String repo) {
        GitHubCommitDetails[] commits = null;
        String uri = baseUri + owner + "/" + repo + "/commits";
        commits = restTemplate.getForObject(uri, GitHubCommitDetails[].class);
        return commits!=null ? Arrays.stream(commits).toList() : List.of();
    }
}
