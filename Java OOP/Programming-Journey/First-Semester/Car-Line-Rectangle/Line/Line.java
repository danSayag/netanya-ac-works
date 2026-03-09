public class Line {

private double x1,x2;
private double y1,y2;


    public  Line() {
	    x1=0.0;
	    y1=1.0;
	    x2=4.0;
	    y2=3.0;
    }


    public Line(double a, double b, double c,double d) {
        x1=a;
        y1=b;
        x2=c;
        y2=d;
    }


    public Line(double a,double b) {
        x1=0;
        y1=0;
	    x2=a;
	    y2=b;
    }


    public double slopeLine() {
        return (y2-y1)/(x2-x1);
	}

    
    public boolean isOn(double a, double b) {
        return b == (slopeLine() * a) + (y1 - slopeLine() * x1);
    }
    

    
    public void show() {
	        System.out.println("("+x1+","+y1+")"+"("+x2+","+y2+")");
			
	
    }
	
    }



