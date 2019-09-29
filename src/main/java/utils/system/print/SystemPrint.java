package utils.system.print;

import utils.system.print.exceptions.BadAmountOfTabsException;

import java.io.PrintStream;

public abstract class SystemPrint {
    private int amountOfTabs = Integer.MIN_VALUE;
    PrintStream printStream = null;

    SystemPrint( int amountOfTabs, PrintStream printStream ) {
        this.amountOfTabs = amountOfTabs;
        this.printStream = printStream;
    }

    String getTabs() throws BadAmountOfTabsException {
        final String functionName = "String getTabs()";
        if( amountOfTabs < 0 ) throw new BadAmountOfTabsException( SystemPrint.class.getName(), functionName, "amountOfTabs < 0. Amount of tabs can NOT be lower than 0.");
        String tabs = "";
        for (int i = 0; i < amountOfTabs; i++) {
            tabs += "\t";
        }
        return tabs;
    }
}
