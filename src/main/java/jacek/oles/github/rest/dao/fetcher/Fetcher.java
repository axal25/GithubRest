package jacek.oles.github.rest.dao.fetcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import jacek.oles.github.rest.model.com.github.api.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import utils.exceptions.CustomExceptionHandler;
import utils.exceptions.ExceptionMessageGenerator;
import utils.system.print.SystemPrintClassNameAndFunctionOut;
import java.util.ArrayList;
import java.util.List;

@Component("fetcher")
public class Fetcher {
    private final RestTemplate restTemplate;

    @Autowired
    public Fetcher(@Qualifier("restTemplate") RestTemplate restTemplate) {
        final String functionName = "@Autowired public Fetcher(@Qualifier(\"restTemplate\") RestTemplate restTemplate)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);
        this.restTemplate = restTemplate;
        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
    }

    public Repo get(String url) {
        final String functionName = "private Repo get(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        Repo repo = null;
        Repo tmpRepo = null;

        tmpRepo = getV1(url);
        if( tmpRepo != null ) repo = tmpRepo;
        tmpRepo = getV2(url);
        if( tmpRepo != null ) repo = tmpRepo;
        tmpRepo = getV3(url);
        if( tmpRepo != null ) repo = tmpRepo;

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private Repo getV1(String url) {
        final String functionName = "private Repo getV1(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        ResponseEntity<?> responseEntity = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Repo>() {
            }
        );
        Repo repo = (Repo) responseEntity.getBody();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private Repo getV2(String url) {
        final String functionName = "private Repo getV2(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        ResponseEntity<?> responseEntity = restTemplate.getForEntity(url, Repo.class);
        Repo repo = (Repo) responseEntity.getBody();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private Repo getV3(String url) {
        final String functionName = "private Repo getV3(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        Repo repo = this.restTemplate.getForObject(url, Repo.class);

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }
}
