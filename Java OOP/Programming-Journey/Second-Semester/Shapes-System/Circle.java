public class circle extends elipt {


public circle(int a){
    super(a, a);
}


public double area(){
    return Math.PI*Math.pow(rWidth, 2);
}



public double scope(){
    return 2*Math.PI*rWidth;
}

public void show(){
    super.show();
    System.out.println("is a circle with a radius of "+rWidth);
}

public boolean equals(Object o){
    if(getClass()!=o.getClass()){
        return false;
    }
    circle c=(circle)o;
    if(rHight!=c.rHight){
        return false;
    }
    if(rWidth!=c.rWidth){
        return false;
    }
    return true;

}

    

}
