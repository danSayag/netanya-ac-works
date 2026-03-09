import java.util.Scanner;
public class Program {
    public static void main(String[] args) throws Exception {
        
        
        Scanner s = new Scanner(System.in);

        System.out.println("Please enter number of sides : ");

        int d = s.nextInt();

        System.out.println("Please enter number of rolls in the experiment: ");

        int r = s.nextInt();

        int iteration = 1;
        while (true) {
            System.out.println("Starting iteration # "+iteration);
            Die my = new Die();
            for( int k = 1; k <= r; k++) my.rollDie(false);
            System.out.println("Starting ite");
            my.showStatistics();

            int[] getAllMostFrequents = my.getAllMostFrequents();
            if(getAllMostFrequents.length >= 2){
                break;
            }
            iteration++;
        }
        System.out.println("Found multiple max frequency. Experiment ended after " + iteration + " iterations");
    }
}
