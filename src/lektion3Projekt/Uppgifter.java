package lektion3Projekt;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Uppgifter {
    public static void main(String[] args) throws IOException {
       findValueInArray();
    }
    static void findValueInArray(){
        int[] findArray = new int[50];
        findArray[0] = 33;
        findArray[1] = 12;
        for (int key:findArray) {
            if (key == 12){
                System.out.println("Value is in array "+23);
            }
        }
    }
    static void fileArray() throws IOException {
        Scanner sc = new Scanner(System.in);

        String input = "";
        while (!input.equals("exit")) {
            System.out.println("Please enter your full name!");
            input = sc.nextLine();
            String fullName = input;
            System.out.println("Please enter file name!");
            input = sc.nextLine();
            String fileName = input;
            String fileContent = "Hej "+fullName+" Here are your randomly grades";
            int[] grades = new int[5];
            for (int i = 0; i < grades.length; i ++){
                grades[i] = rndNumbers(100,1);
            }
            String sprtr = System.getProperty("file.separator");
            String abslutPath = sprtr+"Users"+sprtr+System.getProperty("user.name")+sprtr+"Desktop"+sprtr+fileName;
            System.out.println(abslutPath);


            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(abslutPath));
            for (int i = 0; i < grades.length; i++) {
                fileContent += " Grade "+(i+1)+": \n"+ grades[i];
            }
            fileContent += "Data saved in "+ fileName;
            fileWriter.write(fileContent+".pdf");
            fileWriter.close();
            /**
            try {
                FileWriter fileWrite = new FileWriter(abslutPath);
                PrintWriter prtWrite = new PrintWriter(fileWrite);
                for (int i = 0; i < grades.length; i ++){
                    prtWrite.println(grades[i]);
                }
                prtWrite.close();
            }
            catch (Exception e){
                System.out.println(e);
            }
            **/
             /**File gradesFile = new File(abslutPath);
             if (gradesFile.createNewFile()){
                System.out.println(abslutPath+" File Created");
             }else {System.out.println("File "+abslutPath+" already exists");}**/

        }
    }

    /**
     * Generate random number by range
     * @param max
     * @param min
     * @return
     */
    static int rndNumbers(int max, int min){
        //Creates random double between 0-1
        double rndNr = Math.random();
        //Sets max number
        double rndMax = rndNr * ((max - min) + 1);
        return (int) ((rndMax + min));
    }
    static void basicArrays0() {
        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 100);
            System.out.println("Slot " + i + " contains a " + myArray[i]);
        }
    }

    static void basicArray3() {
        int[] myArray = new int[1000];
        int rnd = 0;

        for (int i = 0; i < myArray.length; i++) {
            int rndRange = rndNumbers(99,1);
            myArray[i] = rndRange;
        }
        for (int i = 0; i < myArray.length; i++){
            if (rnd > 50) {
                System.out.println();
                rnd = 0;
            }
            rnd++;
            System.out.print(" " + myArray[i]);
        }
    }
}
