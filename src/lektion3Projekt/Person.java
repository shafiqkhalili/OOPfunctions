package lektion3Projekt;

public class Person {

    String name;
    String phoneNr;
    int age;
    public Person(){
        this.name = "---";
        this.phoneNr = "---";
        this.age = 0;
    }
    public Person(String name, String phoneNr, int age){
        this.name = name;
        this.phoneNr = phoneNr;
        this.age = age;
    }
    public void print(){
        System.out.println("Name: "+name+" \nPhoneNr: "+phoneNr+" \nAge: "+age);
    }
    public String toString(){
        return "Name: "+name+" 222PhoneNr: "+phoneNr+" Age: "+age;
    }
}
