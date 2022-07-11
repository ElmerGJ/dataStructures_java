
public class test000000_temp {

    public static int getInt(){
        return 2022;
    }

    public static String getString(){
        return "2022";
    }

    public static void noReturn(boolean option){
        if (option)
            getInt();
        else
            getString();
    }

    public static void main(String[] args) {
        Person p1 = new Person(23);
        Person p2 = new Person(100);


        System.out.println("\n\nDIRS 1:\n");

        System.out.println("Dir: 1: " + p1);
        System.out.println("Dir: 2: " + p2);


        System.out.println("\n\nDIRS 2:\n");

        p1 = p2;


        System.out.println("Dir: 1: " + p1);
        System.out.println("Dir: 2: " + p2);


        System.out.println("\n\nDIRS 3:\n");

        Person p3 = p1;


        System.out.println("Dir: 1: " + p1);
        System.out.println("Dir: 2: " + p2);
        System.out.println("Dir: 3: " + p3);


    }

}

class Person{
    int edad;

    Person(int edad){
        this.edad = edad;
    }
}
