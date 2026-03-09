public class Program {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car();
        Car car2 = new Car();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();
        car2.speedUp();
        car2.speedUp();
        System.out.print("car1 ");car1.show();
        System.out.print("car2 ");car2.show();
        car2.slowDown();
        System.out.print("car1 ");car1.show();
        System.out.print("car2 ");car2.show();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();
        System.out.print("car1 ");car1.show();
        System.out.print("car2 ");car2.show();
        car2.speedUp();
        car2.speedUp();
        car2.speedUp();
        car2.speedUp();
        System.out.print("car1 ");car1.show();
        System.out.print("car2 ");car2.show();
        car1.stop();
        car2.stop();
        System.out.print("car1 ");car1.show();
        System.out.print("car2 ");car2.show();
    
    
    
    }
}
