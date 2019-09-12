package jacek.oles.github.rest.dao.fetcher;

import jacek.oles.github.rest.model.Json;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

@Getter
public class FetchException extends IOException {
    private final String callingClassName, callingFunctionName;
    private final HttpStatus httpStatus;
    private final HttpHeaders httpHeaders;
    private final String httpResponseBody;
    private final int rawStatusCode;
    private final String statusText;

    private final Throwable cause;
    private final String message;

    public FetchException(
            String callingClassName,
            String callingFunctionName,
            HttpStatus httpStatus,
            HttpHeaders httpHeaders,
            String httpResponseBody,
            int rawStatusCode,
            String statusText
    ) {
        super(callingClassName + " >>> " + callingFunctionName + " >>> " + FetchException.class.getName() + ": " + "\n\r",
            new Throwable("{ \"rawStatusCode\" : \"" + rawStatusCode + "\" }, { \"statusText\" : \"" + statusText + "\" }")
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

    @Override
    public String toString() {
        return  "exception: " + this.getClass().getName() + ": {" + "\n" +
                "\"callingClassName\" : \"" + this.callingFunctionName + "\"" + "\n" +
                "\"callingFunctionName\" : \"" + this.callingFunctionName + "\"" + "\n" +
                "\"httpStatus\" : \"" + this.httpStatus + "\"" + "\n" +
                "\"httpHeaders\" : \"" + this.httpHeaders + "\"" + "\n" +
                "\"httpResponseBody\" : \"" + this.httpResponseBody + "\"" + "\n" +
                "\"rawStatusCode\" : \"" + this.rawStatusCode + "\"" + "\n" +
                "\"statusText\" : \"" + this.statusText + "\"" + "\n" +
                "\"message\" : \"" + this.message + "\"" + "\n" +
//                "\t" + "\"cause\" : " + Json.toPrettyString( cause ) + "\n" +
                "}";
    }
}
