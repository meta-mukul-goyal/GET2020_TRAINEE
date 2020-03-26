package assignment2;

import java.util.ArrayList;

public class Stack {
	private static ArrayList<Character> stack = new ArrayList<Character>();
	private static ArrayList<Integer> intStack = new ArrayList<Integer>();
	private static String postfixResult = "";

	private static int precedence(char ch){
		if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		else if (ch == '^')
			return 3;
		return -1;
	}
	
	private static char peek() {
		return stack.get(stack.size()-1);
	}
	
	public static String infixToPostfixOperation(String exp) {
		int countparenthsis = 0;
		for (int i=0; i<exp.length(); i++){
			char ch = exp.charAt(i);
			if (Character.isDigit(ch))
				postfixResult += ch;
			else{
				if (ch == '('){
					push(ch);
					countparenthsis++;
				}
				else if (ch == ')'){
					while (!stack.isEmpty() && peek() != '(')
						postfixResult += pop();
					pop();
					countparenthsis--;
				}
				else{
					while (!stack.isEmpty() && precedence(ch) <= precedence(peek()))
						postfixResult += pop();
					push(ch);
				}
			}
		}
		while (!stack.isEmpty())
			postfixResult += pop();

		if (countparenthsis != 0){
			System.out.println("invalid expression");
			return "";
		}
		return postfixResult;
	}
	
	public static char pop() {
		char ch = peek();
		stack.remove(stack.size()-1);
		return ch;
	}


	public static void push(char ch) {
		stack.add(ch);
	}
	
	private static int peekInt() {
		return intStack.get(intStack.size()-1);
	}
	
	public static int popInt() {
		int ch = peekInt();
		intStack.remove(intStack.size()-1);
		return ch;
	}


	public static void pushInt(int ch) {
		intStack.add(ch);
	}

	private static int evaluate(String postfix) {
		for (int i=0; i<postfix.length(); i++){
			char ch = postfix.charAt(i);
			if (Character.isDigit(ch))
				pushInt(Integer.valueOf(ch)-'0');
			else{
				int val1 = popInt();
				int val2 = popInt();
				System.out.println(val1 + " " + val2 );
				if (ch == '+')
					pushInt(val1 + val2);
				else if (ch == '-')
					pushInt(Math.abs(val1 - val2));
				else if (ch == '*')
					pushInt(val1 * val2);
				else
					pushInt(val1 / val2);
			}
		}
		return popInt();
	}
	
	public static void main(String[] args){
		String exp = "1+2*(3*4-5)-6";
		String postfix = Stack.infixToPostfixOperation(exp);
		System.out.println(postfix);
		System.out.println(Stack.evaluate(postfix));
	}
	
}
