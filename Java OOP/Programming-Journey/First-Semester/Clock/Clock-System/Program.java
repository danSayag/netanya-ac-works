public class Program {
    public static void main(String[] args) throws Exception {
        Clock myClock = new Clock();
        myClock.show();
        myClock.tick();
        myClock.tick();
        myClock.show();
        myClock.setMidDay();
        myClock.tick();
        myClock.tick();
        myClock.tick();
        myClock.show();
        Clock yourClock = new Clock();
        yourClock.setMidNight();
        yourClock.show();

        
        }
}
