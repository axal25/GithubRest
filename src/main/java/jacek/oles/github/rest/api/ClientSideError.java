package jacek.oles.github.rest.api;

import jacek.oles.github.rest.model.Json;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.io.InputStream;

@Getter
@AllArgsConstructor
public class ClientSideError {
    private final HttpStatus httpStatus;
    private final HttpHeaders httpHeaders;
    private final String httpResponseBody;
    private final int rawStatusCode;
    private final String statusText;

    @Override
    public String toString() {
        return Json.toPrettyString(this);
    }
}
