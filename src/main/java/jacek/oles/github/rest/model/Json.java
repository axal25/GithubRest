package jacek.oles.github.rest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.exceptions.CustomExceptionHandler;

import java.io.IOException;

public class Json {
    public static String toString( Object object ) {
        final String functionName = "String toString( Object object )";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString( object );
        } catch( Exception e ) {
            jsonString = handleException(functionName, e);
        }
        return jsonString;
    }

    public static String toPrettyString( Object object ) {
        final String functionName = "String toPrettyString( Object object )";
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString( object );
        } catch( Exception e ) {
            jsonString = handleException(functionName, e);
        }
        return jsonString;
    }

    public static Object toObject( String jsonString, Class classRef ) {
        final String functionName = "Object toObject( String jsonString, Class classRef )";
        ObjectMapper objectMapper = new ObjectMapper();
        Object object = null;
        try {
            object = objectMapper.readValue(jsonString, classRef );
        } catch (IOException e) {
            object = handleException(functionName, e);
        }
        return object;
    }

    private static String handleException(String functionName, Exception e) {
        ObjectMapper objectMapper = new ObjectMapper();
        String eMsg = "";
        try {
            eMsg = objectMapper.writeValueAsString( e );
        } catch (JsonProcessingException ex) {
            eMsg = CustomExceptionHandler.handleCustomException(Json.class.getName(), functionName, e);
        }
        return eMsg;
    }
}
