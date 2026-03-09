public class Program {
    public static void main(String[] args) {
         LockableDoor ld1=new LockableDoor();
         ld1.state();
         ld1.open();
         ld1.lock();
         ld1.close();
         ld1.lock();
         ld1.open();
         ld1.unlock();
         ld1.open();
         ld1.unlock();
         ld1.close();
         ld1.lock();
         ld1.unlock();
         ld1.state();
    }
    
}
