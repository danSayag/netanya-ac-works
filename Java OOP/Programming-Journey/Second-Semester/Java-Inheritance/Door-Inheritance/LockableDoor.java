public class LockableDoor extends Door {
    private boolean locked;


    
public LockableDoor(){
    open();
    locked=false;
    System.out.println("your lockable door is open!");
}

public void open(){
    if(locked){
        System.out.println("the door is locked, it can't be opened.");
    }
        else{
            super.open();
            System.out.println("the door is open!");
        }
}

//1.3 יורש מאבא


   public void lock(){
    if(isOpen()==true){
        System.out.println("you can't lock the door, the door is open.");
    }
    else{
        locked=true;
        System.out.println("the door is locked!");
    }
   }

   public void unlock(){
    if(!locked){
        System.out.println("you can't unlock an unlocked door.");
    }
    if(locked){
        System.out.println("you unlouckd the door!");
        locked=false;
    }
}
   

  public void state(){
    if(locked){
        System.out.println("your door is locked");
    }
    if(!locked){
        System.out.println("your door is unlocked");
    }
  }
}
