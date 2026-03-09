import java.util.Scanner;
public class Segment {
    private Point first , second;

    public Segment(){
       first = new Point(0,0);
       second = new Point(1, 1);
    }


    public Segment(float a , float b , float c , float d){
        first = new Point(a,b);
        second = new Point(c,d);
    }


    public Segment(float a , float b){
        first = new Point(a,b);
        second = new Point(0,0);
    }



    public Segment(float a , float b , Point p2 ){
        first = new Point(a , b);
        second = new Point(p2);
    }

    public Segment(Point p , float a , float b){
        first = new Point(p);
        second = new Point(a, b);
    }

    
    public Segment(Segment sg){
        first = new Point(sg.first);
        second = new Point(sg.second);
    }


    public Segment(Point p1 , Point p2){
        first = new Point(p1);
        second = new Point(p2);
    }


    public void show(){
        first.show();
        second.show();
        System.out.println();
    }


    public Point middle(){
        float x = (first.getX()+second.getX())/2;
        float y = (first.getY()+second.getY())/2;
        return new Point(x, y);
    }


    public void readSegment(){
        Scanner s = new Scanner(System.in);
        System.out.println("for the value of x the first point: ");
        first.setX(s.nextFloat());
        System.out.println("for the value of y the first point: ");
        first.setY(s.nextFloat());
        System.out.println("for the value of x the second point: ");
        second.setX(s.nextFloat());
        System.out.println("for the value of y the second point: ");
        second.setY(s.nextFloat());
    }


    public float length(){
        return (float)Math.sqrt((double)Math.pow((double)first.getX()-(double)second.getX(),2)+(double)Math.pow((double)first.getY()-(double)second.getY(),2));
    }


    public boolean greaterThan(Segment sg){
        return length()>sg.length();
    }


    public boolean lessThan(Segment sg){
        return length()<sg.length();
    }


    public boolean equals(Segment sg){
        if(!equals(sg.first))
            return false;
        if(!equals(sg.second))
            return false;
        return true;
    }


    public int compareTo(Segment sg){
        if(length() == sg.length()){
            return 0;
        }   
        if(length() < sg.length()){
            return -1;
        }
        return 1;
    }




        


}