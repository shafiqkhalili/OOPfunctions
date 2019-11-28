package lektion3Projekt;

import java.util.ArrayList;
public class randomClass {
    public static void main(String[] args) {
        ArrayList<Integer> rnd = new ArrayList<>();

        for (int i=0;i<10;i++){
            int randomValue = (int) (Math.random() * 100);
            rnd.add(randomValue);
        }
        System.out.println("Largest nr: "+largestNr(rnd));
        //printList(rnd);
    }
    static void  printList(ArrayList<Integer> lst){
        for (Integer nr : lst){
            System.out.print(nr+" ");
        }
        System.out.println();
    }
    static int largestNr(ArrayList<Integer> myList){
        int largestN = myList.get(0);
        for (int nr: myList) {
            largestN = nr > largestN ? nr : largestN;
        }
        printList(myList);
        return largestN;
    }
}
