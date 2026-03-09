abstract class shapes {


    public abstract void show();
    public abstract double area();


    public int compare(shapes sh){
        if(this.area()>sh.area()){
            return 1;
        }
        if(this.area()<sh.area()){
            return -1;
        }
        return 0;
}   
    



}
