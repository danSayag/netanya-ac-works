public class Program {
    public static void main(String[] args) throws Exception {
        Line line=new Line();
        Line para=new Line(0.0,4.0,16.0,12.0);
        Line perpendicular=new Line(0,-14,-9,4);
        System.out.println(para.slopeLine());
        double x;
        x=perpendicular.slopeLine()*line.slopeLine();
        System.out.println(x);
    }
}
