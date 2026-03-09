public class ball extends shape3D {
     
    private int radius;


    public ball(int radius){
        this.radius = radius;
    }


    public double area() {
        return ((4/3)*Math.PI*Math.pow(radius, 3));

    }


    public double surface(){
        return (4*Math.PI*Math.pow(radius, 2));
    }


    public void show(){
        super.show();
        System.out.println( "is a ball with a depth of " + radius);
    }

    
    public boolean equals(Object o){
        if(getClass()!=o.getClass()){
            return false;
        }
        ball b = (ball)o;
        if(radius!=b.radius){
            return false;
        }

        return true;
}


    


}
