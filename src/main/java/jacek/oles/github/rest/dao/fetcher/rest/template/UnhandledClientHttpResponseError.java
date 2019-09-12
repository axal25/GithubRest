package jacek.oles.github.rest.dao.fetcher.rest.template;

import jacek.oles.github.rest.dao.fetcher.FetchException;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.InputStream;

@Getter
public class UnhandledClientHttpResponseError extends FetchException {
    private final String callingClassName, callingFunctionName;
    private final HttpStatus httpStatus;
    private final HttpHeaders httpHeaders;
    private final String httpResponseBody;
    private final int rawStatusCode;
    private final String statusText;

    private final Throwable cause;
    private final String message;

    public UnhandledClientHttpResponseError(
            String callingClassName,
            String callingFunctionName,
            HttpStatus httpStatus,
            HttpHeaders httpHeaders,
            String httpResponseBody,
            int rawStatusCode,
            String statusText
    ) {
        super(
                callingClassName,
                callingFunctionName,
                httpStatus,
                httpHeaders,
                httpResponseBody,
                rawStatusCode,
                statusText
        );
        this.callingClassName = callingClassName;
        this.callingFunctionName = callingFunctionName;
        this.httpStatus = httpStatus;
        this.httpHeaders = httpHeaders;
        this.httpResponseBody = httpResponseBody;
        this.rawStatusCode = rawStatusCode;
        this.statusText = statusText;

        this.cause = super.getCause();
        this.message = super.getMessage();
    }
}
