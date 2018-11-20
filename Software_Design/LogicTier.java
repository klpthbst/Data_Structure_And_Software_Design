import java.util.LinkedList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public int findNumberOfBooksInYear(int year) {
		
		int count = 0;		
		List<Book> books = dataTier.getAllBooks();
		
		for (Book book : books) {
			count += book.getPublicationYear() == year ? 1 : 0;
		}
		return count;
	}
	
	public List<String> findBookTitlesByAuthor(String author) {
		
		List<Book> books = dataTier.getAllBooks();
		List<String> titles = new LinkedList<>();
		
		for (Book book : books) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase()))
				titles.add(book.getTitle());
		}
		return titles;
	}
}
