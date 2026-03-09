public class Program {
    public static void main(String[] args) throws Exception {
        Rectangle r1 = new Rectangle(3, 4, 5, 2);
        int result = r1.getArea();
        System.out.println(result);
        r1.show();
        Rectangle r2 = new Rectangle(5,6,7,1);
        r2.moveTo(1, 5, 3, 1);
        System.out.println(r1.getDiagoalLength());
        System.out.println(r1.getParimiter());
        System.out.println(r2.getParimiter());
        System.out.println(r1.isSquare());
        System.out.println(r2.isSquare());
    
    }
}
