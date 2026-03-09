public class Rect{

    protected int hight,length;


    
    public Rect(int hight,int length){
        this.hight=hight;
        this.length=length;
    }



    public int getArea(){
        return hight*length;
    }



    public int getCirc(){
        return (hight*2)+(length*2);
    }


}