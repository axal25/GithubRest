package jacek.oles.github.rest.dao;

import jacek.oles.github.rest.dao.fetcher.Fetcher;
import jacek.oles.github.rest.dao.fetcher.FetchException;
import jacek.oles.github.rest.model.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

@Repository("repoDao")
public class RepoDao {
    private final Fetcher fetcher;
    private String host = "https://api.github.com";

    @Autowired
    public RepoDao(@Qualifier("fetcher") Fetcher fetcher) {
        final String functionName = "@Autowired public RepoDao(@Qualifier(\"fetcher\") Fetcher fetcher)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);
        this.fetcher = fetcher;
        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
    }

    public Repo getRepoByUserNameAndRepoName(String userName, String repoName) throws FetchException {
        final String functionName = "public Repo getRepoByUserNameAndRepoName(String userName, String repoName)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        final String url = host + "/repos/" + userName + "/" + repoName;
        String fullUri = "https://api.github.com/repos/axal25/BareJS";

        jacek.oles.github.rest.model.com.github.api.Repo githubApiRepo = this.fetcher.get( url );
        Repo repo = new Repo( githubApiRepo );

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }
}
