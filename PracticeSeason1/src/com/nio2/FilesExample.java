package com.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FilesExample {

	// Use Files class to
	public static void main(String[] args) throws IOException {
		// check,  LinkOption: how symbolic links are handled if file is a Symbolic Link.
		Path path = Paths.get("c://file.txt");
		System.out.println( Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS }) ); 
		System.out.println( Files.notExists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS }) );
		// Read,
			// Read all bytes from file
			byte[] byteArray = Files.readAllBytes(path);
			for (byte b : byteArray) {
				//System.out.print( (char)b );
			}
			System.out.println("");
			// Read all lines from file, bytes decoded into Characters using specified charset.
			//System.out.println(Charset.availableCharsets());
			Charset charset = Charset.forName("UTF-8");
			List<String> listString = Files.readAllLines(path, charset);
			//System.out.println(listString);
		// Delete,
		/* Path path1 = Paths.get("c://file1.txt");
			System.out.println(path1.toFile().exists());
			Files.delete(path1);
			System.out.println(path1.toFile().exists());*/
		// Copy,
		Path source = Paths.get("c://file.txt");
			Path destination = Paths.get("c://file-dest.txt");
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		// Move, in move different name can also be given.
		Files.move(destination, Paths.get("c://moved/file-dest22.txt"), StandardCopyOption.REPLACE_EXISTING);
		// Manage meta-data of a file/directory.
		System.out.println("isDirectory:"+ Files.isDirectory(path, new LinkOption[] { LinkOption.NOFOLLOW_LINKS }) );
			System.out.println("isExecutable:"+ Files.isExecutable(path) );
			System.out.println("isHidden:" + Files.isHidden(path));
	}

}
