package utils.system.print.exceptions;

public class BadAmountOfTabsException extends Exception {
    public BadAmountOfTabsException( String callingClassName, String callingFunctionName, String cause ) {
        super(callingClassName + " >>> " + callingFunctionName + " >>> " +
            BadAmountOfTabsException.class.getName() + ": " + "\n\r" +
            "Exception cause(custom): " + cause,
            new Throwable(cause)
        );
    }
}
