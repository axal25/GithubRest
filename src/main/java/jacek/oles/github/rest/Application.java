package jacek.oles.github.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utils.system.print.SystemPrintClassNameAndFunctionOut;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	    final String functionName = "public static void main(String[] args)";
        SystemPrintClassNameAndFunctionOut systemPrintClassNameAndFunctionOut = new SystemPrintClassNameAndFunctionOut();
        systemPrintClassNameAndFunctionOut.printBegin(Application.class.getName(), functionName);

		SpringApplication.run(Application.class, args);

        systemPrintClassNameAndFunctionOut.printEnd(Application.class.getName(), functionName);
	}

}
