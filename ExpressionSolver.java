import java.util.ArrayList;

/**
 * A class which solves expressions given as strings
 * For the IB Computer Science HL class
 * By Kadin Tucker
 */
public class ExpressionSolver {
    
    /**
     * Given an expression in a string, get the numeric result of the expression
     * Assumes that expressions are properly formatted
     * where the first and last items are numbers
     * and also assumes that operators are separated from numbers by spaces
     */
    public static int getSolution(String expression) {
        ArrayList<String> splitExp = new ArrayList<String>();
        for(String letter: expression.split("\\s+")) {
            splitExp.add(letter);
        }
        while(splitExp.contains("*") || splitExp.contains("/")) {
            int nextTimes = splitExp.indexOf("*");
            int nextDiv = splitExp.indexOf("/");
            if(nextTimes != -1 && (nextDiv == -1 || nextTimes < nextDiv)) {
                int result = Integer.parseInt(splitExp.get(nextTimes - 1)) * Integer.parseInt(splitExp.get(nextTimes + 1));
                for(int i = 0; i < 2; i++) splitExp.remove(nextTimes);
                splitExp.set(nextTimes - 1, Integer.toString(result));
            } else if(nextDiv != -1) {
                int result = Integer.parseInt(splitExp.get(nextDiv - 1)) / Integer.parseInt(splitExp.get(nextDiv + 1));
                for(int i = 0; i < 2; i++) splitExp.remove(nextDiv - 1);
                splitExp.set(nextDiv - 1, Integer.toString(result));
            }
        }
        while(splitExp.contains("+") || splitExp.contains("-")) {
            int nextPlus = splitExp.indexOf("+");
            int nextMinus = splitExp.indexOf("-");
            if(nextPlus != -1 && (nextMinus == -1 || nextPlus < nextMinus)) {
                int result = Integer.parseInt(splitExp.get(nextPlus - 1)) + Integer.parseInt(splitExp.get(nextPlus + 1));
                for(int i = 0; i < 2; i++) splitExp.remove(nextPlus);
                splitExp.set(nextPlus - 1, Integer.toString(result));
            } else if(nextMinus != -1) {
                int result = Integer.parseInt(splitExp.get(nextMinus - 1)) - Integer.parseInt(splitExp.get(nextMinus + 1));
                for(int i = 0; i < 2; i++) splitExp.remove(nextMinus - 1);
                splitExp.set(nextMinus - 1, Integer.toString(result));
            }
        }
        return Integer.parseInt(splitExp.get(0));
    }
    
    /**
     * Gets a string representation of the result of an operation
     */
    public static String getOperationsResult(String expression) {
        return "" + expression + " = " + ExpressionSolver.getSolution(expression);
    }
    
    /**
     * Main method; for testing only
     */
    public static void main(String[] args) {
        System.out.println(ExpressionSolver.getOperationsResult("3 + 5"));
        System.out.println(ExpressionSolver.getOperationsResult("3 - 53 * 5"));
        System.out.println(ExpressionSolver.getOperationsResult("3 / 5"));
        System.out.println(ExpressionSolver.getOperationsResult("5 / 5 * 2 + 8 / 2 + 5"));
        System.out.println(ExpressionSolver.getOperationsResult("5 * 5 + 2 / 2 - 8 + 5 * 5 - 2"));
    }
    
}
