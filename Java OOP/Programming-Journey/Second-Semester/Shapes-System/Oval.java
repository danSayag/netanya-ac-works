public class ovel extends elipt {

    public ovel(int a,int b){
        super(a, b);
    }


    public double area(){
        return Math.PI*rHight*rWidth;
    }
    


    public double scope(){
        return (2*Math.PI*Math.sqrt(((rHight*rHight)+(rWidth*rWidth))/2));
    }


    public void show(){
        super.show();
        System.out.println("is an ovel with a hight of "+rHight+" and width of "+rWidth);
    }

    public boolean equals(Object o){
        if(getClass()!=o.getClass()){
            return false;
        }
        ovel ov=(ovel)o;
        if(ov.rHight!=rHight){
            return false;
        }
        if(ov.rWidth!=rWidth){
            return false;
        }
        return true;
}



}
