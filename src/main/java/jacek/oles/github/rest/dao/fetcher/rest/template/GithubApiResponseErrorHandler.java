package jacek.oles.github.rest.dao.fetcher.rest.template;

import jacek.oles.github.rest.dao.fetcher.FetchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GithubApiResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        final String functionName = "@Override " + "public boolean hasError(ClientHttpResponse clientHttpResponse)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        boolean hasClientOrServerError = false;
        if( isClientHttpResponseStatusClientOrServerError(clientHttpResponse) ) hasClientOrServerError = true;

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        return hasClientOrServerError;
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        final String functionName = "@Override public void handleError(ClientHttpResponse clientHttpResponse)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(this.getClass().getName(), functionName);

        final HttpHeaders headers = clientHttpResponse.getHeaders();
        final HttpStatus httpStatus = clientHttpResponse.getStatusCode();
        final String httpResponseBody = this.readInputStream(clientHttpResponse.getBody());
        final int rawStatusCode = clientHttpResponse.getRawStatusCode();
        final String statusText = clientHttpResponse.getStatusText();
        IOException e = null;

        if( isClientHttpResponseStatusClientOrServerError( clientHttpResponse ) )
            e = new FetchException(
                    this.getClass().getName(),
                    functionName,
                    httpStatus,
                    headers,
                    httpResponseBody,
                    rawStatusCode,
                    statusText
            );
        else
            e = new UnhandledClientHttpResponseError(
                this.getClass().getName(),
                functionName,
                httpStatus,
                headers,
                httpResponseBody,
                rawStatusCode,
                statusText
        );

        systemPrintClassNameAndFunctionOut.printEnd(this.getClass().getName(), functionName);
        throw e;
    }

    private String readInputStream( InputStream inputStream ) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append( line );
            }
            return stringBuilder.toString();
        } catch( Exception e ) {
            return null;
        }
    }

    private boolean isClientHttpResponseStatusClientOrServerError(ClientHttpResponse clientHttpResponse) throws IOException {
        if(
                isClientHttpResponseStatusClientError(clientHttpResponse) ||
                isClientHttpResponseStatusServerError(clientHttpResponse)
        )
            return true;
        else return false;
    }
    private boolean isClientHttpResponseStatusClientError(ClientHttpResponse clientHttpResponse) throws IOException {
        if( clientHttpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR ) return true;
        else return false;
    }

    private boolean isClientHttpResponseStatusServerError(ClientHttpResponse clientHttpResponse) throws IOException {
        if( clientHttpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR ) return true;
        else return false;
    }
}
