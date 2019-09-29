package jacek.oles.github.rest.service;

import jacek.oles.github.rest.dao.RepoDao;
import jacek.oles.github.rest.dao.fetcher.FetchException;
import jacek.oles.github.rest.model.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service("repoService")
public class RepoService {
    private final RepoDao repoDao;

    @Autowired
    public RepoService(@Qualifier("repoDao") RepoDao repoDao) {
        final String functionName = "@Autowired public RepoService(@Qualifier(\"repoDao\") RepoDao repoDao)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);
        this.repoDao = repoDao;
        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
    }

    public Repo getRepoByUserNameAndRepoName(
            @Valid @NotNull @NotBlank String userName,
            @Valid @NotNull @NotBlank String repoName
    ) throws FetchException {
        final String functionName = "public Repo getRepoByUserNameAndRepoName(String userName, String repoName)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        jacek.oles.github.rest.model.Repo repo = this.repoDao.getRepoByUserNameAndRepoName( userName, repoName );

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return repo;
    }
}
