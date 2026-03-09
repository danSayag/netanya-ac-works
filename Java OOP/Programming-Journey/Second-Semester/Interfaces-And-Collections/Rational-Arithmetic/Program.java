
public class Program {
 public static void main(String[] args) throws CloneNotSupportedException {
    
 
   Rational r1=new Rational(1,2);
   Rational r2=new Rational(1,4);
   Rational r3=new Rational(1,0);    
     System.out.println(r2.add(r1));
     System.out.println(r2.sub(r1));
     System.out.println(r2.mul(r2));
     System.out.println(r2.div(r1));
     System.out.println(r3);
     Rational r4=new Rational();
     r4=r3.clone();
     System.out.println(r4);
     r2.show();
 }
    
}
