public class Door {
    private  boolean open;


public Door() {
    this(true); 
}


public Door (boolean  state) {
    open=state;
}


public void open(){
   open=true;
}


public  void  close() {
   open=false;
}



public  boolean  isOpen() {
    return open;
}

}
    