import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		Stack<HtmlTag> stack = new Stack<HtmlTag>();
		for (HtmlTag tag : tags) {
			if (tag.isSelfClosing()) // don't care about self closing tag
				continue;
			if (tag.isOpenTag()) {
				stack.push(tag);
				continue;
			} else {
				
				if (!stack.isEmpty() && tag.matches(stack.peek())) {
					stack.pop();
					continue;
				}
				if (stack.isEmpty())
					return null;
				return stack;
			}
		}
		
		return stack; // this line is here only so this code will compile if you don't modify it
	}
	

}

