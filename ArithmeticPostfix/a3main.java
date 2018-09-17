import java.util.Scanner;

public class a3main {
	static Scanner scan = new Scanner(System.in);
	static char[] charArray = new char[100];

	public static void main(String[] args) {
		System.out.println("Enter an equation to test: ");
		StrToChar();
		ArithmeticPostfix stack = new ArithmeticPostfix(charArray, charArray.length);
		isBalanced(stack, charArray);
	

	}
	public static void StrToChar() {
		String equation = scan.nextLine();
		
		char[] cArray = equation.toCharArray();
		for(int i =0; i<cArray.length; i++) {
			if(cArray[i]==('(') || cArray[i]==('[') || cArray[i]==('{') || cArray[i]==(')') || cArray[i]==(']') || cArray[i]==('}')) {
				charArray[i]=cArray[i];
			}
		}
	}
	
	public static boolean isMatch(char paren1, char paren2) {
		if (paren1 == '(' && paren2 == ')') {
			return true;
		}
		if (paren1 == '[' && paren2 == ']') {
			return true;
		}
		if (paren1 == '{' && paren2 == '}') {
			return true;
		}else {
			return false;
		}
			
	}
	public static boolean isBalanced(ArithmeticPostfix stack, char[] ra) {
		for(int i = 0; i<ra.length; i++) {
			if(ra[i]==('(') || ra[i]==('[') || ra[i]==('{')) {
				stack.push(ra[i]);
			}
			if(ra[i]==(')') || ra[i]==(']') || ra[i]==('}')) {
				if(stack.isEmpty()) {
					System.out.println("Too many right parentheses!");
					return false;
				}
				if(!isMatch(stack.pop(),ra[i])) {
					System.out.println("Balanced but parantheses do not match.");
					return false;
				}
			}
			
		}
		if(stack.isEmpty()) {
			System.out.println("Equation is balanced!");
			return true;
		}else{
			System.out.println("Too many left parentheses!");
			return false;
		}
	}//String equation = new String("(25x[3{4y-3}])(8x{9+68})");
}
