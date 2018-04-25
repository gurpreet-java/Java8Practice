package com.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiExample {
	
	// Use stream api with nio.2
	public static void main(String[] args) {
		// List
		try (Stream<Path> stream = Files.list( Paths.get("c://moved") ) ) {
			List<String> list = 
					stream
						.map(String::valueOf)
						.filter(s -> s.endsWith(".txt"))
						.collect(Collectors.toList());
			System.out.println(list);
		} catch (IOException e) {
			System.out.println( "Exception: " + e.getMessage());
		}
		
		// Find and walk.
		
		// Read lines and buffered reader.
		
	}

}
