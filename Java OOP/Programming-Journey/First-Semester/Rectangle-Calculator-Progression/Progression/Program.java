import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = 0, n2 = 0, num = 0, newMax = 0, maxNum1 = 0, maxNum2 = 0;

        for (int i = 1; i <= 7; i++) {
            n1 = s.nextInt();
            n2 = s.nextInt();
            Progression p1 = new Progression(n1, n2);
            num = p1.sum(5);
            
            if (num > newMax) {
                maxNum1 = n1;
                maxNum2 = n2;
                newMax = num;
            }
        }

        Progression p2 = new Progression(maxNum1, maxNum2);
        p2.showProg(12);
    }
}
