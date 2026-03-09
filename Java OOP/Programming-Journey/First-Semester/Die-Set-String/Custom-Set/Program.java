import java.util.Scanner;
public class Program {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter new set maximal size: ");
        int maximal = s.nextInt();
        Set s1 = new Set(maximal);

        while(true){
            System.out.print("Current set is: ");
            s1.show();
            System.out.println();
            System.out.println("Press 0 to exit program");
            if(s1.isFull()==false){
                System.out.println("Press 1 to add new number to set");
            }
            if(s1.isEmpty()==false){
                System.out.println("Press 2 to remove existing number from set");
            }
            int num = s.nextInt();
            if(num==0){
                break;
            }
            if(s1.isFull()==false){
                if(num==1){
                    System.out.println("Enter new number to add to set: ");
                    int a = s.nextInt();
                    if(s1.add(a)==true){
                        s1.add(a);
                        System.out.println("Adding "+a+" succeeded");
                    }
                    else{
                        System.err.println("Adding "+a+" failed");
                    }
                }
            }
            else{
                System.out.println("You cannot add any number reason: no place in the set");
            }
            if(s1.isEmpty()==false){
                if(num==2){
                    System.out.println("Enter number to remove from set: ");
                    int b = s.nextInt();
                    if(s1.remove(b)==true){
                        s1.remove(b);
                        System.out.println("Removing "+b+" succeeded");
                    }
                    else{
                        System.out.println("Removing "+b+" failed");
                    }
                }
            }
            else{
                System.out.println("You cannot remove any number reason: no number is in the set");
            }
        }
        s.close();
    }
}

