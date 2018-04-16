package com.exceptions;

import java.io.PrintStream;

/*
- Use catch, multi-catch, and finally clauses
- Use Autoclose resources with a try-with-resources statement
- Create custom exceptions and Auto-closeable resources
- Test invariants by using assertions
*/
/*
 * Use try-catch and throw statements
 */
public class BasicExceptions {
	
	private static final PrintStream log = System.out;
	
	public void basicTryCatch() {
		try {
			int c = 2/0;
			log.println(c);
		} catch (ArithmeticException e) {
			log.println("Exception caught: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		BasicExceptions be = new BasicExceptions();
		be.basicTryCatch();
		
	}

}
