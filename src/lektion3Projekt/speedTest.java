package lektion3Projekt;

import java.util.ArrayList;
import java.util.LinkedList;

public class speedTest {

    public static void main(String[] args) {
        Person p1= new Person();
        System.out.println(p1.name);
        Person p2 = new Person("Shafigh","07623",24);

        p1 = new Person("Test","33434",33);
        System.out.println(p1);
        p2.toString();


    }
    static void arrayLst() {
        ArrayList<Integer> arrayLst = new ArrayList<Integer>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayLst.add(i);
        }
        arrayLst.set(500000, 5);
        long endtime = System.currentTimeMillis();
        long elapsedTime = endtime - startTime;
        System.out.println("Elapsed time arrayList: " + elapsedTime);
        System.out.println(arrayLst.get(500000));
    }

    static void arrayLnk() {
        LinkedList<Integer> linkedLst = new LinkedList<Integer>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedLst.add(i);
        }
        linkedLst.set(500000, 5);
        long endtime = System.currentTimeMillis();
        long elapsedTime = endtime - startTime;
        System.out.println("Elapsed time LinkedList: " + elapsedTime);
        System.out.println(linkedLst.get(500000));
    }

}
