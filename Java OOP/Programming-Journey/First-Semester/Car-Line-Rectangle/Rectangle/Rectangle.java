public class Rectangle {

    private int xu , yu ;
    private int xl , yl ;


    public Rectangle(int a , int b , int c , int d){
        xu = a ;
        yu = b ;
        xl = c ;
        yl = d ; 
    }


    public int getArea(){
        return (yu - yl) * (xl - xu);
    }


    public Rectangle(){
        xu = 0 ;
        yu = 0 ;
        xl = 1;
        yl = -1;
    }


    public int getParimiter(){
        return  (getLength()*2)+(getHeight()*2); 
    }


    public void show(){
        System.out.println("xu=" + xu + ", yu=" + yu + ", xl=" + xl + ", yl=" + yl);
    }


    public void moveTo(int x1 , int y1 , int x2 , int y2){
        xu = x1 ;
        yu = y1 ;
        xl = x2 ;
        yl = y2 ;
    }


    public boolean isInside(int x , int y){
        if( x > xu && y > yu && x < xl && y < yl){
           return true;
        }
        else{
            return false;
        }
    }


    public int getLength(){
        return xl - xu;
    }


    public int getHeight(){
        return yu - yl ; 
    }


    public int getDiagoalLength(){
        return (int)Math.sqrt( (getHeight() * getHeight()) + (getLength() * getLength()) );
    }


    public boolean isSquare(){
        return getHeight() == getLength() ; 
    }


    public boolean isGolden(){
        return getLength()*1.618 == getHeight();
    }

    
}
