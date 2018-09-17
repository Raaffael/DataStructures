import java.util.Scanner;

public class a4main {
	static Scanner scan = new Scanner(System.in);
	private static int[] charArray = new int[100] ;
	static char[] cArray= new char[100];
	static ArithmeticPostfix stack;
	static int result;
	

	public static void main(String[] args) {
		StrToChar();
		stack = new ArithmeticPostfix(charArray , charArray.length);
		evaluate(stack, cArray);
		System.out.println("Result: " + result);
	

	}
	public static void StrToChar() {
		System.out.println("Enter an expression to evaluate: ");
		String equation = scan.nextLine();
		cArray = equation.toCharArray();
	}
	
	public static void operate(int num1, int num2, char ra) {
		if (ra=='+') {
			result =  num1+num2;
			stack.push(result);
		}
		if (ra=='-') {
			result =  num2-num1;
			stack.push(result);
		}
		if (ra=='*') {
			result =  num1*num2;
			stack.push(result);
		}
		if (ra=='/') {
			result =  num2/num1;
			stack.push(result);
		}

	}
	public static void evaluate(ArithmeticPostfix stack, char[] cArray) {
		for(int i = 0; i<cArray.length; i++) {
			if(cArray[i]==('+') || cArray[i]==('-') || cArray[i]==('*') || cArray[i]==('/')) {
				int num1 =  stack.pop();
				int num2 =  stack.pop();
				operate(num1, num2, cArray[i]);
			}
			if(Character.isDigit(cArray[i])){
				stack.push(cArray[i] - '0');
			}else {
				char unneeded = cArray[i];
			}
			
		}

	}
}
