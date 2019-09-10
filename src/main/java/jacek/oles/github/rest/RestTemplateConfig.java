package jacek.oles.github.rest;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

@Configuration
public class RestTemplateConfig {

    @Bean("restTemplate")
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        final String functionName = "@Bean public RestTemplate getRestTemplate(RestTemplateBuilder builder)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        RestTemplate restTemplate = builder.build();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return restTemplate;
    }
}
