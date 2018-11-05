# Activity

Implement the following methods in the LinkedListUtils.java file:

## insertSorted: 
This method assumes the input LinkedList is already sorted in non-descending order (i.e.,such that each element is greater than or equal to the one that is before it, and inserts the input int value into the correct location of the list. Note that the method does not return anything, but rather modifies the input LinkedList as a side effect. If the input LinkedList is null, this method should simply terminate.

## removeMaximumValues: 
This method removes all instances of the N largest values in the LinkedList. Because the values are Strings, you will need to use the String class’ compareTo method to find the largest elements; see the Java API for help with that method. If the input LinkedList is null or if N is non-positive, this method should simply return without any modifications to the input LinkedList. Keep in mind that if any of the N largest values appear more than once in the LinkedList, this method should return remove all instances, so it may remove more than N elements overall. The other elements in the LinkedList should not be modified and their order must not be changed.

## containsSubsequence: 
This method determines whether any part of the first LinkedList contains all elements of the second in the same order with no other elements in the sequence, i.e. it should return true if the second LinkedList is a subsequence of the first, and false if it is not. The method should return false if either input is null or empty.

Please do not change the signatures of these three methods (their parameter lists, names, and return value types) and do not create any additional .java files for your solution. If you need additional classes, you can define them in LinkedListUtils.java. Additionally, please be sure that your LinkedListUtils class is in the default package, i.e. there is no “package” declaration at the top of the source code.

