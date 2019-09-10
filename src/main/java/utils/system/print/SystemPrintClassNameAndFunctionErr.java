package utils.system.print;

import utils.exceptions.ExceptionMessageGenerator;
import utils.system.print.exceptions.BadAmountOfTabsException;

public class SystemPrintClassNameAndFunctionErr extends SystemPrintClassNameAndFunction {
    public SystemPrintClassNameAndFunctionErr() {
        super( System.err );
    }
}
