public class cube extends shape3D{


    private int length;
    
    
    public cube(int length){
        this.length=length;
    }


    public double area(){
        return Math.pow(length, 3);
    }


    public double surface(){
        return (6*Math.pow(length, 2));
    }

    public void show(){
        super.show();
        System.out.println("is a cube with length of "+length);
    }

    public boolean equals(Object o){
        if(getClass()!=o.getClass()){
            return false;
        }
        cube c=(cube)o;
        if(length!=c.length){
            return false;
        }
        return true;
}


}
