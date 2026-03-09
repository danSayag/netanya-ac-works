public class Clock{

    private int hours;
    private int minutes;
    private int seconds;
    private int Milliseconds;

    public void tick () {
        Milliseconds = Milliseconds + 1;
        seconds = seconds + Milliseconds /60;
        minutes = minutes + seconds /60;
        hours = hours + minutes /60;
        Milliseconds = Milliseconds %999;
        seconds = seconds %60;
        minutes = minutes %60;
        hours = hours %24;
    }

    public void setMidNight(){
        hours = 0 ;
        minutes = 0 ;
        seconds = 0 ;
        Milliseconds = 0 ;
    }

    public void setMidDay(){
        hours = 12 ;
        minutes = 0 ;
        seconds = 0 ;
        Milliseconds = 0 ;
    }

    public void show(){
        System.out.println("the current time is : " + hours + ":" + minutes + ":" + seconds + ":" + Milliseconds ); 
    }

}