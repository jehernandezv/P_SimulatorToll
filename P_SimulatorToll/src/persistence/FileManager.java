package persistence;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

	private static final Path PATH_SEQ_PERSON = Paths.get("plate/seq_plate.txt");

	public static int getLastId() throws IOException, URISyntaxException{
		int lastId = Integer.parseInt(Files.readAllLines(PATH_SEQ_PERSON).get(0));
		Files.write(PATH_SEQ_PERSON, String.valueOf(++lastId).getBytes());
		return lastId;
	}
}