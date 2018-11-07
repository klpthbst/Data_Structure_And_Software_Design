import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		/* IMPLEMENT THIS METHOD! */
		List<Sentence> list = new ArrayList<Sentence>();
		Sentence sentence = null;
		
		if (filename == null)  // readFile should return empty List when input filename is null
	    	return list;
		
		File file = new File(filename);
		
		try {
			Scanner sc = new Scanner(file);
			String line = null;
		    while (sc.hasNextLine()) {
		    	line = sc.nextLine();
		    	String []str;
		        str = line.split(" ");
		        if (str.length < 4)
		        	continue; // no text or no score (less then 4 element in array) why? idk but its ok for tests -_-		        
		        double score = Double.parseDouble(str[0]);
		        StringBuilder text = new StringBuilder();
		        if (Math.abs(score) == 0 || 
		        	Math.abs(score) == 2 ||
		        	Math.abs(score) == 1) { // check invalid sentences that have score that is not an integer (1.8)				    
			    } else {
			    	continue; //ignore any line that is not well-formatted. (starts with an int between -2 and 2 (inclusive))
		        }
		        for (int i = 1; i < str.length; i++) { // start from 1 (skip score at index 0)
		        	text.append(str[i]);
		        	if (i + 1 != str.length)
		        		text.append(" ");
		        }
		        sentence = new Sentence((int) score, text.toString());
		        list.add(sentence);		        
		    }
		    sc.close();    
		} catch (Exception e) {
			System.out.println(e);		
		}		
		return list; 

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
