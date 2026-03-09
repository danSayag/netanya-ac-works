import java.util.Scanner;
public class Rectangle {

    private int height, width;
    
    public Rectangle (int h, int w) {
        this.height = h;
        this.width = w;
    }

    /*  void drawFilled(){
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print("*");
            }
        System.out.println();
        }
    }
*/
    public void drawEmpty(){
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(i==0 || i==height-1 || j==0 || j==width-1)
                    System.out.print("*");
                else{
                    System.out.print(" ");
                }
            }
        System.out.println();
        }  
    } 

    public void drawFilled(char a){
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                System.out.print(a);
            }
        System.out.println();
        }
    }

    public void drawEmpty(char a){
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(i==0 || i==height-1 || j==0 || j==width-1)
                    System.out.print(a);
                else{
                    System.out.print(" ");
                }
            }
        System.out.println();
        }  
    } 

    public void readRectFromConsole(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please new enter width");
        width=s.nextInt();
        System.out.println("Please new enter height");
        height=s.nextInt();
    }
}
