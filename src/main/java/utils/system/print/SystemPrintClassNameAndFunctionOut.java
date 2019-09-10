package utils.system.print;

import utils.exceptions.ExceptionMessageGenerator;
import utils.system.print.exceptions.BadAmountOfTabsException;

public class SystemPrintClassNameAndFunctionOut extends SystemPrintClassNameAndFunction {
    public SystemPrintClassNameAndFunctionOut() {
        super( System.out );
    }
}
