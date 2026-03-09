import java.util.Scanner;
public class Program2 {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Calculator c1 = new Calculator();
        System.out.println("Please enter some number");
        int number = sc.nextInt();
        System.out.println("The number you entered is " + number);
        if(c1.inSymmetric(number)){
            System.out.println("The number "+number+" is symmetric");
        }
        if(!(c1.inSymmetric(number))){
            System.out.println("The number "+number+" isn't stmmetric");
        
        int n = number;
        while(!(c1.inSymmetric(number))){
            number++;
        }
        System.out.println("The first symmetric number after "+ n + " is " + number);
    }
}
}
