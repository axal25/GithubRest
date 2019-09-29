package jacek.oles.github.rest.api;

import jacek.oles.github.rest.dao.fetcher.FetchException;
import jacek.oles.github.rest.dao.fetcher.rest.template.GithubApiResponseErrorHandler;
import jacek.oles.github.rest.dao.fetcher.rest.template.RestTemplateConfig;
import jacek.oles.github.rest.model.Repo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes={RestTemplateConfig.class})
@RestClientTest
public class GithubApiResponseErrorHandlerTests {

    @Autowired
    private MockRestServiceServer mockServer;

    @Autowired
    private RestTemplate restTemplate;

    final String url = "/repos/user1/repo2";

    @DisplayName("Test Spring jacek.oles.github.rest.dao.fetcher.rest.template.GithubApiResponseErrorHandlerTests class #1")
    @Test
    public void testGithubApiResponseErrorHandler1() {
        try {
            assertNotEquals(null, this.restTemplate);
            assertNotEquals(null, this.mockServer);
            this.mockServer
                    .expect(MockRestRequestMatchers.requestTo(url))
                    .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                    .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND));
            this.mockServer
                    .expect(MockRestRequestMatchers.requestTo(url))
                    .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                    .andRespond(MockRestResponseCreators.withStatus(HttpStatus.NOT_FOUND));
            System.out.println("Line after this causes exception - it is supposed to.");
            Repo response = restTemplate.getForObject(url, Repo.class);
        } catch( Exception e ) {
            System.err.println("class = " + e.getClass().getName());
            assertEquals(e instanceof RuntimeException, true);
            assertEquals(e.getClass(), ResourceAccessException.class);
        }
        assertThrows(ResourceAccessException.class, () -> {
            Repo response = restTemplate.getForObject(url, Repo.class);
        });
        this.mockServer.verify();
    }
}
