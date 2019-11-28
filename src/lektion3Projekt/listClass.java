package lektion3Projekt;

import java.util.ArrayList;
import java.util.Arrays;

public class listClass {
    public static void main(String[] args) {
        /**String[] myArray = {"Ema","Alex","Shafigh"};
        int[] myInts = {1,2,3,4};**/

        ArrayList<String> myList = new ArrayList<>(Arrays.asList("Naveed", "Test"));

        myList.add("Shafigh");
        System.out.println(myList.size());
        for (String s: myList
             ) {
            System.out.println(s);
        }
        //System.out.println(contains(myArray,"Shafighd"));
    }
    static boolean contains(String[] hey, String needle){
        for (String ndl:hey) {
            if(ndl.equals(needle)){
                return true;
            }
        }
        return false;
    }
    static boolean contains(int[] hey, int needle){
        for (int ndl:hey) {
            if(ndl == needle){
                return true;
            }
        }
        return false;
    }
}
