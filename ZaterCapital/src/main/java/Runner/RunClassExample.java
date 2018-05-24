package Runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RunClassExample {

	public static void main(String[] args) {

		
		Result result = JUnitCore.runClasses(JunitTestSuite.class);
	    
		for (Failure fail : result.getFailures()) {
	        System.out.println(fail.toString());
	    }
	    if (result.wasSuccessful()) {
	        System.out.println("All tests finished successfully...");
	    }
	    
		

	}

}
