

import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		
		if (list == null) {
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > value) {				
				list.add(i, value);
				return;
			} else if (list.get(i) == value) {
				list.add(i, value);
				return;
			} else {
				continue;
			}
		}
		list.addLast(value);
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		
		String max = "";
		if (list == null || N < 0) {
			return;
		}
		while (N > 0 && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				max = list.get(i).compareTo(max) > 0 ? list.get(i) : max;
			}
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).compareTo(max) == 0) {
						list.remove(i);
				}
			}
			N--;
			max = "";
		}

	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		
		if (one == null || two == null || two.isEmpty() || one.size() < two.size())
			return false;
		
		int tmpSize = two.size();
		int k = 0;
		boolean flag = false;

		for (int i = 0, j = 0; i < one.size(); i++) {
			if (one.get(i) == two.get(j)) {
				j++;
				tmpSize--;
				if (!flag) {
					flag = true;
					k = i;
				}
				if (tmpSize == 0) {
					return true;
				}
			} else {
				if (flag) {
					i = k;
					flag = false;
				}
				j = 0;
			}
		}
		return false; // this line is here only so this code will compile if you don't modify it
	}
}
