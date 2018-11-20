import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks() {
		
		File f = new File(fileName);
		List<Book> allBooks = new ArrayList<>();
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String[] book = sc.nextLine().split("\t");
				allBooks.add(new Book(book[0], book[1], Integer.valueOf(book[2])));
			}
			sc.close();
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return allBooks;
	}

}
