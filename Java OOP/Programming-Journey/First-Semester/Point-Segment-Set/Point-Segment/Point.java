public class Point {
    private float x,y;
    

    public Point(Point p){
        x = p.x;
        y = p.y;
    }


    public Point(float x , float y){
        this.x=x;
        this.y=y;
    }

    public void show(){
        System.out.print("("+x+","+y+")");;
    }


    public float getX(){
        return x;
    }


    public float getY(){
          return y;
    }


    public void setX(float x){
        this.x=x; 
    }


    public void setY(float y){
        this.y=y; 
    }


    public boolean equals(Point p){
        if(y != p.y)
            return false;
        if(x != p.x)
            return false;
        return true;
    }

    

}
