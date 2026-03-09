abstract class elipt extends shape2D {

protected int rHight,rWidth;

public abstract double area();
public abstract double scope();

public elipt(int rHight,int rWidth){
    this.rHight=rHight;
    this.rWidth=rWidth;
}



public void show(){
    super.show();
    System.out.print(" is a round shape ");
}
    
}
