package aiss.laboratorio4.service;

import aiss.laboratorio4.model.GitHubCommitDetails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    @DisplayName("Get all commits")
    void findAllCommits() {
        List<GitHubCommitDetails> commits = service.findAllCommits("spring-projects", "spring-framework");
        assertNotNull(commits, "The list of commits is empty");
        for (GitHubCommitDetails commit : commits) {
            System.out.println(commit.getCommit());
        }
    }
}