package jacek.oles.github.rest.api;

import jacek.oles.github.rest.dao.fetcher.FetchException;
import jacek.oles.github.rest.dao.fetcher.rest.template.UnhandledClientHttpResponseError;
import jacek.oles.github.rest.model.Repo;
import jacek.oles.github.rest.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

@RequestMapping("repositories")
@RestController
public class RepoController {
    private final RepoService repoService;

    @Autowired
    public RepoController(@Qualifier("repoService") RepoService repoService) {
        final String functionName = "@Autowired public RepoController(@Qualifier(\"repoService\") RepoService repoService)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);
        this.repoService = repoService;
        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
    }

    @GetMapping(path = "{userName}/{repoName}")
    public Repo getRepoByUserNameAndRepoName(@PathVariable("userName") String userName,
                                             @PathVariable("repoName") String repoName) throws FetchException {
        final String functionName = "@GetMapping(path = \"{userName}/{repoName}\") " +
                "public Repo getRepoByUserNameAndRepoName(@PathVariable(\"userName\") String userName, " +
                "@PathVariable(\"repoName\") String repoName)";

        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        jacek.oles.github.rest.model.Repo repo = this.repoService.getRepoByUserNameAndRepoName(userName, repoName);

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }

    @ExceptionHandler({FetchException.class, UnhandledClientHttpResponseError.class})
    public ResponseEntity<ClientSideError> handleFetchException(FetchException e) {
        final String functionName = "@ExceptionHandler({FetchException.class, UnhandledClientHttpResponseError.class}) " +
                "public ResponseEntity<String> handleFetchException(FetchException e)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        ClientSideError clientSideError = new ClientSideError(
            e.getHttpStatus(),
            e.getHttpHeaders(),
            e.getHttpResponseBody(),
            e.getRawStatusCode(),
            e.getStatusText()
        );
        ResponseEntity<ClientSideError> responseEntity = new ResponseEntity<ClientSideError>(
                clientSideError,
                clientSideError.getHttpStatus()
        );

        System.err.println("FetchException e.getMessage() = " + e.getMessage());
        System.err.println("FetchException e.getCause() = " + e.getCause());

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return responseEntity;
    }
}
