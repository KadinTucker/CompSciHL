import java.util.Scanner;

/**
 * The class which handles the count 'em right project
 * in the IB Computer Science HL class
 * By Kadin Tucker
 */
public class CountEmRight {

    /**
     * Main method; repeatedly asks the user for input
     * Finds the number of occurrences of the string "sa" in the input
     * then tells the user the number of occurrences
     */
    public static void main(String[] args) {
        boolean continueLoop = true;
        Scanner inputScanner = new Scanner(System.in);
        while(continueLoop) {
            System.out.print("Type in a sentence and press ENTER. ");
            String inputString = inputScanner.nextLine().toUpperCase().replaceAll(" ", "");
            if(inputString.equals("EXIT")) {
                continueLoop = false;
            } else {
                inputString += " ";
                String[] sp = inputString.split("SA");
                System.out.println("There are " + (sp.length - 1) + " occurrence(s).\n");
            }
        }
    }
    
}
