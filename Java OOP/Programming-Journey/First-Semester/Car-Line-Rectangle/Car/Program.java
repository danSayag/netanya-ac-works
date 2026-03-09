public class Program {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("12345", 120);
        Car car2 = new Car("123456", 120);
        car1.speedUp(5);
        car2.speedUp();
        car1.show();
        car2.show();
        int rnd = (int)(Math.random() * 150 + 50);
        car2.speedUp(rnd);
        
        if (car2.getSpeed() != 30){
            if(car2.getSpeed() < 30){
                int temp = (car2.getSpeed()-30)*(-1);
                car2.speedUp(temp);
            }
            if(car2.getSpeed() > 30){
                int temp = car2.getSpeed()-30;
                car2.slowDown(temp);
            }
        }
        car2.show();
    }
}
