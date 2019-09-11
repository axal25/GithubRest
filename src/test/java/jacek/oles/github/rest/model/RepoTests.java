package jacek.oles.github.rest.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RepoTests {
    public static final String userName = "axal25";
    public static final String repoName = "BareJS";

    @DisplayName("Test Spring com.github.api.Repo class #1")
    @Test
    public void testRepoClass1() {
        jacek.oles.github.rest.model.com.github.api.Repo githubApiRepo = jacek.oles.github.rest.model.com.github.api.RepoTests.getGithubApiRepo();
        Repo repo = new Repo( githubApiRepo );
        assertNotEquals(null, repo);
    }

    @DisplayName("Test Spring jacek.oles.github.rest.model.Repo class #2")
    @Test
    public void testRepoClass2() {
        jacek.oles.github.rest.model.com.github.api.Repo githubApiRepo = jacek.oles.github.rest.model.com.github.api.RepoTests.getGithubApiRepo();
        Repo repo = new Repo( githubApiRepo );
        assertEquals(githubApiRepo.getFull_name(), repo.getFullName());
        assertEquals(githubApiRepo.getDescription(), repo.getDescription());
        assertEquals(githubApiRepo.getClone_url(), repo.getCloneUrl());
        assertEquals(githubApiRepo.getCreated_at(), repo.getCreatedAt());
        assertEquals(githubApiRepo.getStargazers_count(), repo.getStars());
    }
}
