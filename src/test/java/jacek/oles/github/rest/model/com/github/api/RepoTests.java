package jacek.oles.github.rest.model.com.github.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jacek.oles.github.rest.model.Json;
import jacek.oles.github.rest.model.Repo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RepoTests {

    @DisplayName("Test Spring com.github.api.Repo class #1")
    @Test
    public void testComGithubApiUserClass1() {
        RestTemplate restTemplate = new RestTemplate();
        String fullUri = "https://api.github.com/repos/axal25/BareJS";
        Repo repo = restTemplate.getForObject(fullUri, Repo.class);
        assertNotEquals(null, repo);
    }

    @DisplayName("Test Spring com.github.api.User class #2")
    @Test
    public void testComGithubApiUserClass2() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Repo expectedRepo = null;
        String jsonExpectedRepo = this.getAxal25BareJSRepoJsonString();
        Object unknownObject = Json.toObject(jsonExpectedRepo, Repo.class);
        if(unknownObject instanceof Repo) {
            expectedRepo = ((Repo) unknownObject);
            RestTemplate restTemplate = new RestTemplate();
            String fullUri = "https://api.github.com/repos/axal25/BareJS";
            Repo actualRepo = restTemplate.getForObject(fullUri, Repo.class);
            System.out.println();
            System.out.println("expectedRepo: \t" + expectedRepo);
            System.out.println("actualRepo: \t" + actualRepo);
            System.out.println();
            assertEquals(expectedRepo.toString(), actualRepo.toString());
        } else if(unknownObject instanceof String) {
            String eMsg = (String) unknownObject;
            System.err.println("Error: " + eMsg);
        } else throw new Exception("unknownObject of unknown type");
    }

    public String getAxal25BareJSRepoJsonString() {
        return "{\n" +
                "   \"id\": 201328930,\n" +
                "   \"node_id\": \"MDEwOlJlcG9zaXRvcnkyMDEzMjg5MzA=\",\n" +
                "   \"name\": \"BareJS\",\n" +
                "   \"full_name\": \"axal25/BareJS\",\n" +
                "   \"private\": false,\n" +
                "   \"owner\":    {\n" +
                "      \"login\": \"axal25\",\n" +
                "      \"id\": 10118389,\n" +
                "      \"node_id\": \"MDQ6VXNlcjEwMTE4Mzg5\",\n" +
                "      \"avatar_url\": \"https://avatars2.githubusercontent.com/u/10118389?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/axal25\",\n" +
                "      \"html_url\": \"https://github.com/axal25\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/axal25/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/axal25/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/axal25/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/axal25/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/axal25/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/axal25/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/axal25/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/axal25/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/axal25/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "   },\n" +
                "   \"html_url\": \"https://github.com/axal25/BareJS\",\n" +
                "   \"description\": \"Bare JavaScript - Learning project in JavaScript\",\n" +
                "   \"fork\": false,\n" +
                "   \"url\": \"https://api.github.com/repos/axal25/BareJS\",\n" +
                "   \"forks_url\": \"https://api.github.com/repos/axal25/BareJS/forks\",\n" +
                "   \"keys_url\": \"https://api.github.com/repos/axal25/BareJS/keys{/key_id}\",\n" +
                "   \"collaborators_url\": \"https://api.github.com/repos/axal25/BareJS/collaborators{/collaborator}\",\n" +
                "   \"teams_url\": \"https://api.github.com/repos/axal25/BareJS/teams\",\n" +
                "   \"hooks_url\": \"https://api.github.com/repos/axal25/BareJS/hooks\",\n" +
                "   \"issue_events_url\": \"https://api.github.com/repos/axal25/BareJS/issues/events{/number}\",\n" +
                "   \"events_url\": \"https://api.github.com/repos/axal25/BareJS/events\",\n" +
                "   \"assignees_url\": \"https://api.github.com/repos/axal25/BareJS/assignees{/user}\",\n" +
                "   \"branches_url\": \"https://api.github.com/repos/axal25/BareJS/branches{/branch}\",\n" +
                "   \"tags_url\": \"https://api.github.com/repos/axal25/BareJS/tags\",\n" +
                "   \"blobs_url\": \"https://api.github.com/repos/axal25/BareJS/git/blobs{/sha}\",\n" +
                "   \"git_tags_url\": \"https://api.github.com/repos/axal25/BareJS/git/tags{/sha}\",\n" +
                "   \"git_refs_url\": \"https://api.github.com/repos/axal25/BareJS/git/refs{/sha}\",\n" +
                "   \"trees_url\": \"https://api.github.com/repos/axal25/BareJS/git/trees{/sha}\",\n" +
                "   \"statuses_url\": \"https://api.github.com/repos/axal25/BareJS/statuses/{sha}\",\n" +
                "   \"languages_url\": \"https://api.github.com/repos/axal25/BareJS/languages\",\n" +
                "   \"stargazers_url\": \"https://api.github.com/repos/axal25/BareJS/stargazers\",\n" +
                "   \"contributors_url\": \"https://api.github.com/repos/axal25/BareJS/contributors\",\n" +
                "   \"subscribers_url\": \"https://api.github.com/repos/axal25/BareJS/subscribers\",\n" +
                "   \"subscription_url\": \"https://api.github.com/repos/axal25/BareJS/subscription\",\n" +
                "   \"commits_url\": \"https://api.github.com/repos/axal25/BareJS/commits{/sha}\",\n" +
                "   \"git_commits_url\": \"https://api.github.com/repos/axal25/BareJS/git/commits{/sha}\",\n" +
                "   \"comments_url\": \"https://api.github.com/repos/axal25/BareJS/comments{/number}\",\n" +
                "   \"issue_comment_url\": \"https://api.github.com/repos/axal25/BareJS/issues/comments{/number}\",\n" +
                "   \"contents_url\": \"https://api.github.com/repos/axal25/BareJS/contents/{+path}\",\n" +
                "   \"compare_url\": \"https://api.github.com/repos/axal25/BareJS/compare/{base}...{head}\",\n" +
                "   \"merges_url\": \"https://api.github.com/repos/axal25/BareJS/merges\",\n" +
                "   \"archive_url\": \"https://api.github.com/repos/axal25/BareJS/{archive_format}{/ref}\",\n" +
                "   \"downloads_url\": \"https://api.github.com/repos/axal25/BareJS/downloads\",\n" +
                "   \"issues_url\": \"https://api.github.com/repos/axal25/BareJS/issues{/number}\",\n" +
                "   \"pulls_url\": \"https://api.github.com/repos/axal25/BareJS/pulls{/number}\",\n" +
                "   \"milestones_url\": \"https://api.github.com/repos/axal25/BareJS/milestones{/number}\",\n" +
                "   \"notifications_url\": \"https://api.github.com/repos/axal25/BareJS/notifications{?since,all,participating}\",\n" +
                "   \"labels_url\": \"https://api.github.com/repos/axal25/BareJS/labels{/name}\",\n" +
                "   \"releases_url\": \"https://api.github.com/repos/axal25/BareJS/releases{/id}\",\n" +
                "   \"deployments_url\": \"https://api.github.com/repos/axal25/BareJS/deployments\",\n" +
                "   \"created_at\": \"2019-08-08T20:02:37Z\",\n" +
                "   \"updated_at\": \"2019-08-26T11:43:44Z\",\n" +
                "   \"pushed_at\": \"2019-08-26T11:43:42Z\",\n" +
                "   \"git_url\": \"git://github.com/axal25/BareJS.git\",\n" +
                "   \"ssh_url\": \"git@github.com:axal25/BareJS.git\",\n" +
                "   \"clone_url\": \"https://github.com/axal25/BareJS.git\",\n" +
                "   \"svn_url\": \"https://github.com/axal25/BareJS\",\n" +
                "   \"homepage\": null,\n" +
                "   \"size\": 775,\n" +
                "   \"stargazers_count\": 0,\n" +
                "   \"watchers_count\": 0,\n" +
                "   \"language\": \"JavaScript\",\n" +
                "   \"has_issues\": true,\n" +
                "   \"has_projects\": true,\n" +
                "   \"has_downloads\": true,\n" +
                "   \"has_wiki\": true,\n" +
                "   \"has_pages\": true,\n" +
                "   \"forks_count\": 0,\n" +
                "   \"mirror_url\": null,\n" +
                "   \"archived\": false,\n" +
                "   \"disabled\": false,\n" +
                "   \"open_issues_count\": 0,\n" +
                "   \"license\": null,\n" +
                "   \"forks\": 0,\n" +
                "   \"open_issues\": 0,\n" +
                "   \"watchers\": 0,\n" +
                "   \"default_branch\": \"master\",\n" +
                "   \"network_count\": 0,\n" +
                "   \"subscribers_count\": 1\n" +
                "}";
    }
}
