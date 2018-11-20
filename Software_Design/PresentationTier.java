import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	Scanner sc;
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		
		showBookTitlesByAuthor();
		showNumberOfBooksInYear();
	}

	public int showNumberOfBooksInYear() {
		
		sc = new Scanner(System.in);
		int year = sc.nextInt();
		logicTier.findNumberOfBooksInYear(year);
		return year;
		
	}

	public void showBookTitlesByAuthor() {
		
		sc = new Scanner(System.in);
		String author = sc.next();
		List<String> titles = logicTier.findBookTitlesByAuthor(author);
		for (String string : titles) {
			System.out.println(string);
		}
	}
	

}
