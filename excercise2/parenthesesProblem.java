package excercise2;

import week2.ResizingArrayStack;

public class parenthesesProblem {
	
	
	public boolean checkParentheses(String s) {
		ResizingArrayStack<Character> stack = new ResizingArrayStack<Character>();
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
				stack.push(s.charAt(i));
			}else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}') {
				if(stack.isEmpty()) return false;
				char val = stack.pop();
				if(!((s.charAt(i)==')' && val=='(') || (s.charAt(i)==']' && val=='[') || (s.charAt(i)=='}' && val=='{'))) {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/*
	 * IMPLEMENTATION of Specs ends here
	 * Main method for testing
	 * 
	 */
	
	public static void main(String[] args) {
		String s = "[{()}][]";
		parenthesesProblem obj = new parenthesesProblem();
		System.out.println(obj.checkParentheses(s));
				
	}
}


