public class square extends polygons {

    public square(int h){
      super(h, h);
    }


    public void show(){
      super.show();
      System.out.println("is a squre with hight and width of "+hight);

    }

 
    public boolean equals(Object o){
      if(getClass()!=o.getClass()){
          return false;
      }
      square a = (square)o;
      if(hight!=a.hight){
        return false;
      }    
      return true;
  
}



    
}
