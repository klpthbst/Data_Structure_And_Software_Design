## Activity 

### Part 1. Reading the corpus as an input file
Implement the `readFile` method in `Analyzer.java`.
This method should take the name of the file to read and read it one line at a time, creating `Sentence` objects 
and putting them into the `List`. Note that the method returns a `List` containing `Sentence` objects.\
For a valid sentence such as:
`2 I am learning a lot .`\
then the `score` field of the `Sentence` object should be set to `2`, and the `text` field should be `I am learning a lot .`\
Your code should ignore (and not create a `Sentence` object for) any line that is not well-formatted, which we assume to mean 
`starts with an int between -2 and 2 (inclusive)`, `has a single whitespace, and then is followed by more text.`\
However, if the file cannot be opened for reading or if the input `filename` is null, this method should return an empty `List`.\
Note that it is up to you to determine which `List` implementation to return; 
any decision is fine, as long as it implements the `List` interface and you do not change the signature of this method.\
If you do not have prior experience writing `Java` code to read a text file, feel free to look online for help. 
There is good documentation at 
https://docs.oracle.com/javase/tutorial/essential/io/file.html \
and good tutorials elsewhere online.\
Please do not change the signature of the `readFile` method and do not modify `Sentence.java`.\
Also, please do not create new `.java` files. If you need to create new classes, add them to `Analyzer.java`.\
Last, please make sure that your  `Analyzer` class is in the default package, i.e. there is no `package` 
declaration at the top of the source code.

### Part 2. Calculating the sentiment of each word
Implement the `allWords` method in `Analyzer.java` (the same file as Part 1).\
This method should find all of the individual tokens/words 
in the `text` field of each `Sentence` in the `List` and create `Word` objects for each distinct word.\
The `Word` objects should keep track of the number of occurrences of that word in all `Sentences`,\
and the total cumulative score of all `Sentences` in which it appears.\
This method should then return a `Set` of those `Word` objects.\
If the input `List` of `Sentences` is null or is empty, the `allWords` method should return an empty `Set`.\
If a `Sentence` object in the input `List` is null, this method should ignore it and process the non-null `Sentences`.\
As you can see, `allWords` needs to tokenize/split the `text` of each `Sentence` to get the individual words.\
Consult the Java documentation for help with this:\
https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html \
or feel free to find a tutorial online.\
Keep in mind that when you tokenize the text of each `Sentence`, you will be getting `Strings`,\
but the `Set` that this method returns needs to include `Word` objects.\
However, if two `Strings` are equal, they should be combined into the same Word object,\
which should track the cumulative `score` of all `Sentences` containing that `String`.\
As you may have noticed in the data file we provided,\
some tokens start with punctuation and the first word of each sentence starts with a capital letter.\
In producing the `Set` of `Words`, your program should ignore any token that does not start with a letter.\
Also, this method should convert all strings to lowercase so that it is case-insensitive.\
Do not assume that the strings in the `Sentence` objects have already been converted to lowercase.\
As an example, consider this text:
`It 's a lot of fun to learn about data structures.`\
Your program should convert ` It  to  it ` (to make it lowercase) and ignore  `'s`
and the period at the end of the sentence since those tokens do not start with a letter.\
As in Part 1, it is up to you to determine which `Set` implementation to return; 
any decision is fine, as long as it implements the `Set` interface and you do not change the signature of this method.
Hint: although this method needs to return a `Set of Words`, you may find it easier to use 
a different data structure while processing each `Sentence`, 
and then put the combined results into a `Set` before the method returns. 
There is not necessarily a single `correct` way to implement this method, as long as you return the proper `Set` of 
`Words` at the end.
Please do not change the signature of the `allWords` method and do not modify `Sentence.java` or `Word.java`. 
Also, please do not create new `.java` files. If you need to create new classes, add them to `Analyzer.java`. 
Last, please make sure that your `Analyzer` class is in the default package, i.e. there is no `package` 
declaration at the top of the source code.
### Part 3. Storing the sentiment of each word
Implement the `calculateScores` method in `Analyzer.java` (the same file as Parts 1 and 2).\
This method should iterate over each `Word` in the input `Set`, use the `Word’s calculateScore` method 
to get the average sentiment score for that `Word`, 
and then place the text of the `Word` (as key) and calculated score (as value) in a `Map`.\
If the input `Set` of `Words` is null or is empty, the `calculateScores` method should return an empty `Map`.\
If a `Word` object in the input `Set` is null, this method should ignore it and process the non-null `Words`.
As above, it is up to you to determine which `Map` implementation to return; 
any decision is fine, as long as it implements the `Map` interface and you do not change the signature of this method.\
Please do not change the signature of the `calculateScores` method and do not modify `Sentence.java` or `Word.java`.
Also, please do not create new `.java` files. If you need to create new classes, add them to `Analyzer.java`.  
Analyzer class is in the default package, i.e. there is no `package` declaration at the top of the source code.

### Part 4. Determining the sentiment of a sentence
Finally, implement the `calculateSentenceScore`method in Analyzer.java.\
This method should use the `Map` to calculate and return the average score of all the words in the input sentence.\
Note that you will need to `tokenize/split` the sentence, as you did in Part 2.\
If a word in the sentence does not start with a letter, then you can ignore it, 
but if it starts with a letter and is not present in the `Map`, assign it a score of 0.\
You may assume that all words in the `Map` consist only of lowercase letters (since this would have been done in previous steps)
but do not assume that all words in the input sentence consist only of lowercase letters; 
you should convert them to lowercase before checking whether they’re contained in the `Map`.
If the input `Map` is null or empty, or if the input sentence is null or empty or does not contain any valid words, 
this method should return 0.\
Although you can (should!) test each method individually, 
you can test the entire program using the main method in `Analyzer.java`. 
Be sure to specify the name of the input file as the argument to `main`.

Please do not change the signature of the `calculateSentenceScore`
method and do not modify `Sentence.java` or `Word.java`. Also, please do not create new `.java` files.
If you need to create new classes, add them to `Analyzer.java`. 
Last, please make sure that your  `Analyzer` class is in the default package, i.e. there is no `package` 
declaration at the top of the source code.
