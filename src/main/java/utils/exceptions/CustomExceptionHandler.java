package utils.exceptions;

import utils.system.print.SystemPrintClassNameAndFunctionErr;

public class CustomExceptionHandler {
    public static String handleCustomException( String callingClassName, String callingFunctionName, Exception e ) {
        String eMsg = ExceptionMessageGenerator.getMessage( callingClassName, callingFunctionName, e );
        SystemPrintClassNameAndFunctionErr systemPrintClassNameAndFunctionErr = new SystemPrintClassNameAndFunctionErr();
        systemPrintClassNameAndFunctionErr.printBegin(callingClassName, callingFunctionName);
        System.err.println( eMsg );
        systemPrintClassNameAndFunctionErr.printEnd(callingClassName, callingFunctionName);
        return eMsg;
    }
}
