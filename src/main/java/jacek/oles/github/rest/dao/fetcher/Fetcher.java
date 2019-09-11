package jacek.oles.github.rest.dao.fetcher;

import jacek.oles.github.rest.model.com.github.api.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
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

    public Repo get(String url) throws FetchException {
        final String functionName = "private Repo get(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        Repo repo = null;
        try {
            repo = getV1( url );
        } catch( Exception eV1 ) {
            String eMsgV1 = ExceptionMessageGenerator.getMessage(this.getClass().getName(), functionName, eV1);
            try {
                repo = getV2(url);
            } catch( Exception eV2 ) {
                String eMsgV2 = ExceptionMessageGenerator.getMessage(this.getClass().getName(), functionName, eV2);
                try {
                    repo = getV3(url);
                } catch( Exception eV3 ) {
                    String eMsgV3 = ExceptionMessageGenerator.getMessage(this.getClass().getName(), functionName, eV3);
                    throwCombinedException(functionName, eV1, eV2, eV3);
                }
            }
        }
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
                new ParameterizedTypeReference<Repo>() {}
        );
        ResponseEntity<Repo> responseEntityRepo = (ResponseEntity<Repo>) responseEntity;
        Repo repo = responseEntityRepo.getBody();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private Repo getV2(String url) {
        final String functionName = "private Repo getV2(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        ResponseEntity<Repo> responseEntityRepo = restTemplate.getForEntity(url, Repo.class);
        Repo repo = responseEntityRepo.getBody();

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private Repo getV3(String url) {
        final String functionName = "private Repo getV3(String url)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        Repo repo = restTemplate.getForObject(url, Repo.class);

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    private void throwCombinedException(
            String callingFunctionName,
            Exception eV1,
            Exception eV2,
            Exception eV3) throws FetchException {
        String eMsgFromGithub = "eMsgFromGithub";
        HttpStatus httpStatusFromGithub = HttpStatus.NOT_FOUND;
        List<Exception> exceptionList = new ArrayList<Exception>();
        exceptionList.add( eV1 );
        exceptionList.add( eV2 );
        exceptionList.add( eV3 );
        throw new FetchException(
                this.getClass().getName(),
                callingFunctionName,
                eMsgFromGithub,
                httpStatusFromGithub,
                exceptionList);
    }
}
