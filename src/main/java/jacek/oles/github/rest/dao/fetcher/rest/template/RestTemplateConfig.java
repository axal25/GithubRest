package jacek.oles.github.rest.dao.fetcher.rest.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

@Configuration
public class RestTemplateConfig {

    @Bean("restTemplate")
    @Scope("prototype")
    @Autowired
    public RestTemplate getRestTemplate(
            RestTemplateBuilder builder,
            @Qualifier("githubApiResponseErrorHandler") GithubApiResponseErrorHandler githubApiResponseErrorHandler
    ) {
        final String functionName = "    @Bean(\"restTemplate\") @Scope(\"prototype\") @Autowired " +
                "public RestTemplate getRestTemplate(RestTemplateBuilder builder)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        RestTemplate restTemplate = builder
                .errorHandler(githubApiResponseErrorHandler)
                .build();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return restTemplate;
    }

    @Bean("githubApiResponseErrorHandler")
    @Scope("prototype")
    public GithubApiResponseErrorHandler getGithubApiResponseErrorHandler() {
        final String functionName = "@Bean(\"githubApiResponseErrorHandler\") " +
                "@Scope(\"prototype\") " +
                "public GithubApiResponseErrorHandler getGithubApiResponseErrorHandler()";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        GithubApiResponseErrorHandler githubApiResponseErrorHandler = new GithubApiResponseErrorHandler();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return githubApiResponseErrorHandler;
    }
}
