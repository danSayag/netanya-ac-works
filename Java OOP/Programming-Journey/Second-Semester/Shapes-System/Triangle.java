public class triangle extends polygons{



   public triangle(int w,int h){
    super(w, h);
   }



   public double area(){
    return (hight*width)/2;
   }


   public int scope(){
    int a = ((hight*hight)+(width*width));
    return (int)Math.sqrt(a);
   }


   public void show(){
      super.show();
      System.out.println("is a triangle with hight of "+hight+" and width of "+width);
   }


   public boolean equals(Object o){
      if(getClass()!=o.getClass()){
          return false;
      }
      triangle t=(triangle)o;
      if(width!=t.width){
         return false;
      }
      if(hight!=t.hight){
         return false;
      }
      return true;
}


}