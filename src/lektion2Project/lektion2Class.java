package lektion2Project;
import java.util.Scanner;

public class lektion2Class {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while(!input.equals("quit")) {
            System.out.println("Skriv ett ord eller mening:");
            input = sc.nextLine();

            boolean answer = isPalindromMirror(input) ;
            System.out.println("Är det ett palindrom? " + answer );
        }

    }

    /**
     * Check if string is Palindrom by reversing string
     * @param input String
     * @return  Boolean
     */
    static boolean isPalindromMirror(String input){
        String reversedString = "";

        for (int i = input.length()-1; i >=0; i--) {
            reversedString += input.charAt(i);
        }
        return  reversedString.equals(input);
    }
    /**
     * Check if string is Palindrom. Case sensitive
     * @param input Text to compare
     * @return Bool
     */
    static boolean isPalindrom(String input) {
        int lastPos = input.length() - 1;
        input = input.toLowerCase();

        for(int i = 0; i < input.length() * 0.5; i++) {
            if(input.charAt(i) != input.charAt(lastPos - i) ) {
                return false;
            }
        }
        return true;
    }
}
