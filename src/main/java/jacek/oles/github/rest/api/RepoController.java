package jacek.oles.github.rest.api;

import jacek.oles.github.rest.dao.fetcher.FetchException;
import jacek.oles.github.rest.model.Json;
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

    @ExceptionHandler({FetchException.class})
    public ResponseEntity<String> handleFetchException(FetchException e) {
        final String functionName = "@ExceptionHandler({FetchException.class}) " +
                "public ResponseEntity<String> handleFetchException(FetchException e)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        ClientSideError clientSideError = new ClientSideError( e.getHttpStatus(), e.getCause().toString() );
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(
                Json.toPrettyString( clientSideError ),
                clientSideError.getHttpStatus()
        );

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return responseEntity;
    }
}
