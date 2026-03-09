abstract class polygons extends shape2D {

    protected int width,hight;


    public polygons(int width,int hight){
        this.width=width;
        this.hight=hight;
    }


    public double area(){
        return width*hight;
    }


    public int scope(){
        return hight+hight+width+width;
    }


    public void show(){
        super.show();
        System.out.print("is polygon ");
    }



}
