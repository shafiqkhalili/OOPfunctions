package lektion1Project;
import java.util.Scanner;

public class lektion1Class {
    public static void main(String[] args) {
        // uppgift1();
        // uppgift2();
        uppgift3();

    }

    public static void uppgift3(){
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(!input.equals("exit")){
            System.out.println("Skriv ett 10 siffrigt personnummer: ");
            String personNr = sc.nextLine();
            input = personNr;
            //Delete non digits
            personNr = personNr.replaceAll("\\D+", "");
            //Remove first two digits if personNr is 12 digits
            if(personNr.length() > 10){
                personNr = personNr.substring(2);
            }
            boolean validDate = validateDate(personNr);
            if (validDate){
                System.out.println("personNr: "+personNr);
                int personNrTotal = 0;
                int lastPersonNr = 0;
                lastPersonNr = Character.getNumericValue(personNr.charAt(personNr.length()-1));
                // lastPersonNr = (10 - (personNrTotal % 10)) % 10;
                System.out.println("lastPersonNr: "+lastPersonNr);

                int multiplyBy = 2;
                for(int i = 0; i < personNr.length()-1; i++){
                    if(Character.isDigit(personNr.charAt(i))){
                        int charac = Character.getNumericValue(personNr.charAt(i));

                        int nrMultiplied = charac*multiplyBy;
                        int temp, digit = 0;
                        //making a copy of the input number
                        temp = nrMultiplied;
                        //counting digits in the input number
                        // System.out.println("multiplied: "+ nrMultiplied);
                        while(temp > 0)
                        {
                            digit = temp % 10;
                            System.out.println("digit: "+ digit);
                            temp = temp / 10;
                            // System.out.println("temp: "+ temp);
                            personNrTotal += digit;
                        }
                        multiplyBy = multiplyBy == 2 ? 1 : 2;
                        System.out.println(i);
                    }
                    else{
                        System.out.println("Ogiltigt personNr");
                    }
                }
                // Smaller multiple
                int a = ((personNrTotal) / 10) * 10;
                System.out.println("a: "+a);
                // Larger multiple
                int b = a + 10;
                System.out.println("b: "+b);
                int remainedNr = b - personNrTotal;

                // int remainedNr = (10 - (personNrTotal % 10)) % 10;
                System.out.println("remainedNr: "+remainedNr);

                if(lastPersonNr == remainedNr){
                    System.out.println("Correct personNr!"+personNrTotal);
                }
                else{
                    System.out.println("Wrong personNr!"+personNrTotal);
                }
            }
            else {
                System.out.println("Fel personNr!");
            }
        }
        sc.close();
    }

    static boolean validateDate(String personNr){
        boolean valid = true;

        if(personNr.length() != 10){
            valid = false;
        }
        String year = personNr.substring(0,2);
        String month = personNr.substring(2,4);
        String day = personNr.substring(4,6);
        System.out.println("Year:" + year+" Month: "+month+" Day: "+day);
        return valid;
    }

    public static void uppgift2(){
        //The year can be evenly divided by 4;
        // If the year can be evenly divided by 100, it is NOT a leap year, unless;
        // The year is also evenly divisible by 400. Then it is a leap year.
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv ett år: ");
        int year = sc.nextInt();
        if(year%4==0 || (year%400==0 && year%100>0)){
            System.out.println(year + " är ett skottår!");
        }
        else{
            System.out.println(year + " är inte skottår!");
        }
        sc.nextLine();
    }
    public static void uppgift1(){
        double famnToCM = 178;
        double alnToCM = 59.38;
        double tumToCM = 2.54;
        double fotToCM = 30.48;
        double lengdValue;

        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv längden i Famn: ");
        lengdValue = sc.nextDouble();
        double famnInCM = lengdValue *  famnToCM;
        System.out.println(lengdValue +" Famn i CM är: "+famnInCM);

        System.out.println("Skriv längden i Aln: ");
        lengdValue = sc.nextDouble();
        double alnInCM = lengdValue *  alnToCM;
        System.out.println(lengdValue + " Aln i CM är: "+alnInCM);

        System.out.println("Skriv längden i Tum: ");
        lengdValue = sc.nextDouble();
        double tumInCM = lengdValue *  tumToCM;
        System.out.println(lengdValue + " Tum i CM är: "+tumInCM);

        System.out.println("Skriv längden i Fot: ");
        lengdValue = sc.nextDouble();
        double fotInCM = lengdValue *  fotToCM;
        System.out.println(lengdValue + " Fot i CM är: "+fotInCM);
    }
}

