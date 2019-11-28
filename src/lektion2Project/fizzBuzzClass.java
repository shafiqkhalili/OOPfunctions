package lektion2Project;

public class fizzBuzzClass {
    public static void main(String[] args) {
        fizzBuzz();
    }
    public static void fizzBuzz(){
        for (int i = 1; i <= 100; i++) {
            boolean isFizz = (i%3) == 0;
            boolean isBuzz = (i%5) == 0;
            boolean isFizzBuzz = isFizz && isBuzz;


            String output = "";
            if (isFizzBuzz) {
                output = "FizzBuzz: "+i;
            }
            else if(isFizz){
                output = isFizz+" Fizz: "+i;
            }
            else if(isBuzz){
                output = isBuzz+" Buzz: "+i;
            }
            else{
                output = ""+i;
            }

            System.out.println(output);
        }
    }
}
