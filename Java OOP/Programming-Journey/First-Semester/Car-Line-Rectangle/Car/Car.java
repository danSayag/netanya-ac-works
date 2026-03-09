public class Car { 

    private int speed;
    private String licensePlate;
    private int maxSpeed;

    public Car(String licensePlate , int maxSpeed){
        this.licensePlate = licensePlate;
        this.maxSpeed = maxSpeed ;
        speed = 0 ;
    }

    public void speedUp(){
        if(speed == maxSpeed){
            speed = maxSpeed;
        }
        else{
            speed = speed + 1 ;
        }
    }

    public void slowDown(){
        speed = speed-1+1/(speed+1) ;
    }

    public void stop(){
        speed = 0;
    }

    public int getSpeed(){
        return speed;
    }

    public void speedUp(int kpm){
        if(kpm <= 0)
            return;
        if( speed+kpm > maxSpeed)
            return;
        speed = speed + kpm;
        
    }

    public void slowDown(int kpm){
        if(kpm <= 0 )
            return;
        if(speed - kpm < 0 )
            return;
        speed = speed - kpm;
    }

    public void show(){
        System.out.println("license plate = " + licensePlate + ", speed = " + speed + " KPM, max speed = " + maxSpeed);

    }

}