/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, PriorityQueue<Integer>> movieMap = new TreeMap<>();
		if (allUsersRatings == null || allUsersRatings.size() == 0)
			return movieMap;		
		for (UserMovieRating user : allUsersRatings) {
			PriorityQueue<Integer> movieQueue = new PriorityQueue<Integer>();
			if (user == null || user.getMovie() == null || user.getMovie().length() == 0  || user.getUserRating() < 0)
				continue;
			if (!movieMap.containsKey(user.getMovie().toLowerCase())) {
				if (movieQueue.add(user.getUserRating()))
					movieMap.put(user.getMovie().toLowerCase(), movieQueue);
			} else {
				movieMap.get(user.getMovie().toLowerCase()).add(user.getUserRating());
			}
		}
		return movieMap;
	}

}
