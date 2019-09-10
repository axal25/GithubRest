package jacek.oles.github.rest.api;

import org.springframework.http.HttpStatus;

public class ClientSideError {
    private final HttpStatus httpStatus;
    private final String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ClientSideError(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
