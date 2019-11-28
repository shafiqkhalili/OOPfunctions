package lektion2Project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class numberGameClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        System.out.println("Vänligen välj en av följande siffror:");
        System.out.println("1 - Addera två tal");
        System.out.println("2 - Räkna bokstäver i en sträng");
        System.out.println("3 - Spegelvänd en sträng");
        System.out.println("4 - Summera alla tal i en sträng");
        System.out.println("5 - Quite game");
        int selectOption = sc.nextInt();
        switch (selectOption) {
            case 1:
                addDigits();
                break;
            case 2:
                countCharacters();
                break;
            case 3:
                textMirror();
                break;
            case 4:
                addNumbersFromString();
                break;
            case 5:
                input = 5;
                break;
        }

    }

    /**
     * Ask user two digits and plus them
     */
    static void addDigits() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv första talet:");
        int firstNr = sc.nextInt();
        System.out.println("Skriv andra talet:");
        int scndNr = sc.nextInt();
        System.out.println("Summar är: " + (firstNr + scndNr));
    }

    /**
     * Find nr of times a character repeated in string
     */
    static void countCharacters() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv texten:");
        String input = sc.nextLine();
        input = input.trim();
        System.out.println("Skriv bokstaven du letar efter:");
        String charac = sc.nextLine();
        Pattern pattern = Pattern.compile(charac); //case insensitive, use [g] for only lower
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) count++;
        System.out.println(charac+ " exists " + count + " times in " + input);
    }


    /**
     * Mirror string
     */
    static void textMirror() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv texten:");
        String input = sc.nextLine();
        String mirroredTxt = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            mirroredTxt = mirroredTxt + input.charAt(i);
        }
        System.out.println(input + " spegelvänd blir " + mirroredTxt);
    }

    /**
     * Add digits together
     */
    static void addNumbersFromString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv texten:");
        String input = sc.nextLine();
        input = input.trim();
        String mirroredTxt = "";
        for (int i = 0; i < input.length(); i++) {
            mirroredTxt = mirroredTxt + input.charAt(i);
        }
    }
}
