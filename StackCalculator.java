import java.util.Scanner;

/**
 * A stack-based calculator which, in a static context
 * uses reverse polish style operations
 * For the IB HL Computer Science class
 * By Kadin Tucker
 */
public class StackCalculator {
    
    public static void main(String[] args) {
        StackLL stack = new StackLL();
        Scanner inputScanner = new Scanner(System.in);
        
        String userInput = "";
        while(!userInput.equals("Q")) {
            System.out.print("Enter number, math operation(+, -, *, or /), or Q to quit: ");
            userInput = inputScanner.nextLine();
            try {
                stack.push(Double.parseDouble(userInput));
            } catch(NumberFormatException e) {
                if(userInput.equals("+")) stack.push(stack.pop() + stack.pop());
                else if(userInput.equals("-")) stack.push(-1 * stack.pop() + stack.pop());
                else if(userInput.equals("*")) stack.push(stack.pop() * stack.pop());
                else if(userInput.equals("/")) stack.push(1.0 / (stack.pop() / stack.pop()));
            }
        }
        System.out.println("The answer is " + stack.peek());
    }
    
}
