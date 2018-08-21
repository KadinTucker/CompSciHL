import java.util.Arrays;

/**
 * The class which handles the functionalities of the AscendDescend and 
 * SortStringArray projects in the IB Comp Sci HL class
 * By Kadin Tucker
 */
class AscendDescend {
    
    /**
     * Main method; intializes an array of various names (strings)
     * and sorts them before printing them out line by line
     */
    public static void main(String[] args) {
        //Initialize the array of names, called ss
        String[] ss = {"Bill", "Mary", "Lee", "Agnes", "Alfred", "Thomas", "Alvin",
                "Bernard", "Ezra", "Herman"};
        //Sort the array using java Arrays sort; sorts alphabetically
        Arrays.sort(ss);
        //Get the maximum name length
        int maxLength = 0;
        for(String name: ss) {
            if(name.length() > maxLength) {
                maxLength = name.length();
            }
        }
        //Ensure that the length is at least 6, which is the length of "Ascend"
        if(maxLength < 6) {
            maxLength = 6;
        }
        System.out.print("Ascend");
        //Print spaces before descend, the necessary amount as to fit everything
        //Padding is 4 spaces beyond the longest name's length  
        //Length of ascend is 6, so the number of spaces necessary for padding is 
        // maxLength - 2 (4-6)
        for(int i = 0; i < maxLength - 2; i++) {
            System.out.print(" ");
        }
        //Print out descend and make a new line
        System.out.println("Descend\n");
        //Now print the names
        for(int i = 0; i < ss.length; i++) {
            System.out.print(ss[i]);
            //Make spaces so that each name is on the same level when descending
            //Padding is four spaces beyond the longest
            for(int j = 0; j < maxLength - ss[i].length() + 4; j++) {
                System.out.print(" ");
            }
            //Print the name descending
            System.out.println(ss[ss.length - 1 - i]);
        }
    }
    
}