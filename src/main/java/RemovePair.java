package src.main.java;

import java.util.Stack;

public class RemovePair {
	public int solution(String s)
	{
		int answer = -1;

		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i < s.length(); i++) {
			if(stack.size() == 0) {
				stack.push(s.charAt(i));
			} else if(stack.size() > 0) {
				if(s.charAt(i) == stack.peek()) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}

		if(stack.size() == 0) {
			answer = 1;
		} else {
			answer = 0;
		}

		return answer;
	}
}
