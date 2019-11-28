package lektion2Project;
import java.util.Scanner;
import java.util.Random;

public class highLowClass {
    public static void main(String[] args) {
        highLow();
    }
    public static void highLow(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        int tryNr = 1;
        System.out.println("Select game difficulty: 1 > Easy, 2 > Medium, 3 > Difficult");
        int gameDifficulty = sc.nextInt();

        int randomNr = randomNr(gameDifficulty);

        while(!input.equals("quit")) {

            System.out.println("Guess correct nr !");
            int guessedNr = sc.nextInt();
            if (randomNr == guessedNr){
                System.out.println("Bravo! you finished in  "+tryNr+" tries");
                System.out.println("Game finished!");
                input = "quit";
                //sc.close();
            }
            else if(randomNr > guessedNr){
                System.out.println("Your guessed nr is smaller than correct answer!");
            }
            else if(randomNr < guessedNr){
                System.out.println("Your guessed nr is greaterR than correct answer!");
            }
            tryNr++;
        }
    }
    static int randomNr(int difficulty){
        int maxLoop = 10;
        switch (difficulty){
            case 1:
                maxLoop = 10;
                break;
            case 2:
                maxLoop = 100;
                break;
            case 3:
                maxLoop = 1000;
                break;
        }
        Random random = new Random();
        return random.nextInt(maxLoop+1);
    }
}
