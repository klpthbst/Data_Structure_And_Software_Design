/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> list = new LinkedList<>();
		Set<String> treeSet = new TreeSet<>();
		
		if (movieRatings == null || movieRatings.isEmpty())
			return list;
		treeSet = movieRatings.keySet();
		for (String string : treeSet) {
			list.add(string);
		}
		return list; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> list = new LinkedList<>();
		
		if (movieRatings == null || movieRatings.isEmpty())
			return list;
		for (Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
			for (Integer val : movie.getValue()) {
				if (rating < val)				
					list.add(movie.getKey());
				break;
			}
		}
		return list; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, Integer> removedMap = new TreeMap<>();
		List<String> toRemove = new ArrayList<>();
		
		if (movieRatings == null || movieRatings.isEmpty())
			return removedMap;
		
		for (Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
			int count = 0;
			int size = 0;
			Iterator<Integer> it = movie.getValue().iterator();
			size = movie.getValue().size();
			while (it.hasNext()) {
				if (it.next() >= rating)
					break;
				it.remove();
				count++;
			}
			if (count != 0)  // something was removed!
				removedMap.put(movie.getKey(), count);
			if (count == size) // all values was removed!
				toRemove.add(movie.getKey());
		}
		for (int i = 0; i < toRemove.size(); i++) {
			if (movieRatings.containsKey(toRemove.get(i)))
				movieRatings.remove(toRemove.get(i));				
		}	
		toRemove.clear();
		return removedMap;
	}
}
