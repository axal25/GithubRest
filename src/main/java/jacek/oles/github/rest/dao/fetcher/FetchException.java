package jacek.oles.github.rest.dao.fetcher;

import org.springframework.http.HttpStatus;

import java.util.List;

public class FetchException extends Exception {
    private final String callingClassName, callingFunctionName;
    private final List<Exception> exceptionList;
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public FetchException(
            String callingClassName,
            String callingFunctionName,
            String cause,
            HttpStatus httpStatus,
            List<Exception> exceptionList
    ) {
        super(callingClassName + " >>> " + callingFunctionName + " >>> " + FetchException.class.getName() + ": " + "\n\r" +
            "Exception cause(custom): " + cause,
            new Throwable(cause)
        );
        this.callingClassName = callingClassName;
        this.callingFunctionName = callingFunctionName;
        this.httpStatus = httpStatus;
        this.exceptionList = exceptionList;
    }
}
