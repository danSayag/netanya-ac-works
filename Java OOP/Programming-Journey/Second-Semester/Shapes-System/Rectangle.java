public class rectangle extends polygons{

    public rectangle(int w,int h){
        super(w, h);
    }


    public void show(){
        super.show();
        System.out.println("is a rectangle with hight of "+hight+" and width of "+width);
    }

    
    public boolean equals(Object o){
        if(getClass()!=o.getClass()){
            return false;
        }
        rectangle r=(rectangle)o;
        if(width!=r.width){
            return false;
        }   
        if(hight!=r.hight){
            return false;
        }

        return true;
        }

    
    
}
