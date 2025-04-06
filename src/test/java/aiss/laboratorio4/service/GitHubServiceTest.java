package aiss.laboratorio4.service;

import aiss.laboratorio4.model.Commit;
import aiss.laboratorio4.model.GitHubCommitDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GitHubServiceTest {

    @Autowired
    GitHubService service;

    @Test
    @DisplayName("Get all commits without token")
    void findAllCommits() {
        List<GitHubCommitDetails> commits = service.findAllCommits("spring-projects", "spring-framework");
        assertNotNull(commits, "The list of commits is empty");
        for (GitHubCommitDetails commit : commits) {
            System.out.println(commit.getCommit());
        }
    }

    @Test
    @DisplayName("Get all commits at once with a bearer token")
    void getCommitsWithToken() {
        List<Commit> commits =
                service.getAllCommitsWithToken("spring-projects", "spring-framework");

        assertNotNull(commits);
        assertFalse(commits.isEmpty(), "The list of commits is empty");
        commits.forEach(System.out::println);
    }

    @Test
    @DisplayName("Get commits paginated with a bearer token")
    void getCommitsPaginatedIterationsWithToken() {
        List<Commit> commitsPerPage =
                service.getCommitsNPageToken("spring-projects","spring-framework", "5", "3");
        assertNotNull(commitsPerPage);
    }

    @Test
    @DisplayName("Get ALL commits paginated with a bearer token")
    void getAllCommitsPaginatedWithToken() {
        List<Commit> allCommitsPaginated =
                service.getAllCommitsPaginatedToken("0ut0flin3","Talk2GPT", "20");
        assertNotNull(allCommitsPaginated);
    }

}