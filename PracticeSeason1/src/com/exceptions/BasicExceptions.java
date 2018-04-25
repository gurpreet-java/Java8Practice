package com.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class BasicExceptions {
	
	private static final PrintStream log = System.out;
	
	// Use catch, multi-catch, and finally clauses
	public void basicTryCatch() {
		try {
			int c = 2/0;
			log.println(c);
		} catch (ArithmeticException e) {
			log.println("Exception caught: "+e.getMessage());
		}
	}
	
	/*
	 *  Use Autoclose resources with a try-with-resources statement
	 */
	public void autocloseResources() throws IOException {
		String path = "D://code back up/MyRepositories/Java8Practice/PracticeSeason1/src/com/exceptions/basic.txt";
		BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
		try {
			log.println(reader.readLine());
		} finally {
			reader.close();
		}
		// No need of catch or finally.
		try (BufferedReader readerAutoclose = new BufferedReader(new FileReader(new File(path)))) {
			log.println(readerAutoclose.readLine());
		}
		// Custom Auto-Close resource.
		class MyResource implements AutoCloseable {
			@Override
			public void close() throws IOException {
				log.println(this.getClass() + " closed !");
			}
		}
		try (MyResource myResource = new MyResource()) {
			log.println(myResource.getClass() + " accessed.");
		}
	}
	
	/*
	 *  Create custom exceptions and Auto-closeable resources
	 */
	public void customException() throws MyException {
		throw new MyException("null pointer exception.");
	}
	
	/*
	 *	Test invariants by using assertions. 
	 */
	
	public static void main(String[] args) {
		BasicExceptions be = new BasicExceptions();
		be.basicTryCatch();
		try {
			be.autocloseResources();
		} catch (IOException e) {
			e.printStackTrace();
			log.println(e.getMessage());
		}
	}
	
	class MyException extends Exception {
		private static final long serialVersionUID = 1L;
		public MyException(String e) {
			log.println("Exception occured: "+e);
		}
	}
	
}
