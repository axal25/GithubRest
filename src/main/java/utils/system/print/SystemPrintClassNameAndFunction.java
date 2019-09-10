package utils.system.print;

import utils.exceptions.ExceptionMessageGenerator;
import utils.system.print.exceptions.BadAmountOfTabsException;

import java.io.PrintStream;

abstract class SystemPrintClassNameAndFunction extends SystemPrint {
    SystemPrintClassNameAndFunction(PrintStream printStream) {
        super( 20, printStream );
    }

    @Override
    String getTabs() {
        final String functionName = "private String getTabs()";
        try {
            return super.getTabs();
        } catch(BadAmountOfTabsException e) {
            String eMsg = ExceptionMessageGenerator.getMessage(SystemPrintClassNameAndFunctionErr.class.getName(), functionName, e);
            System.err.println( eMsg );
            return eMsg;
        }
    }

    private String getBegin(String functionAndClassName) {
        return this.getTabs() + "\\/\\/\\/ " + functionAndClassName + " \\/\\/\\/";
    }

    public void printBegin(String functionAndClassName) {
        (this.printStream).println( this.getBegin( functionAndClassName ) );
    }

    private String getEnd(String functionAndClassName) {
        return this.getTabs() + "/\\/\\/\\ " + functionAndClassName + " /\\/\\/\\";
    }

    public void printEnd(String functionAndClassName) {
        (this.printStream).println( this.getEnd( functionAndClassName ) );
    }

    public String getBegin(String className, String functionName) {
        return this.getBegin( className + " >>> " + functionName );
    }

    public void printBegin(String className, String functionName) {
        (this.printStream).println( this.getBegin( className, functionName ) );
    }

    public String getEnd(String className, String functionName) {
        return this.getEnd( className + " >>> " + functionName );
    }

    public void printEnd(String className, String functionName) {
        (this.printStream).println( this.getEnd( className, functionName ) );
    }
}
