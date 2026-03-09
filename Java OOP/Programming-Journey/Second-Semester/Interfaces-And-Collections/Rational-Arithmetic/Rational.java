public class Rational implements Showable,Arithmetic,Cloneable {

    private int mone,mechane;


    public Rational(int mone, int mechane) {
        this.mone = mone;
        this.mechane = checkMechane(mechane);
    }



    public static int checkMechane(int a){
        if(a==0){
        return 1;
        }
        return a;
    }
    


    public Rational(){
        mone=1;
        mechane=2;
    }


    public Rational(Rational r){
        mone=r.mone;
        mechane=r.mechane;
    }


    public String toString(){
        return mone+"/"+mechane;
    }


    public boolean equals(Rational r){
        return (mone*r.mechane)==(r.mone*mechane);
    }


    public void show(){
        System.out.println(mone+"/"+mechane);
    }

    
    public Rational add(Object o){
        Rational result = new Rational();
        if(o.getClass()==Rational.class){
            Rational r = (Rational)o;
            result.mone=(mone*r.mechane)+(r.mone*mechane);
            result.mechane=mechane*r.mechane;
            return result;
        }
        else{
            System.out.println("its not a Rational");
            return null;
        }
    }

    
    public Rational sub(Object o){
        Rational result = new Rational();
        if(o.getClass()==Rational.class){
            Rational r = (Rational)o;
            result.mone=(mone*r.mechane)-(r.mone*mechane);
            result.mechane=mechane*r.mechane;
            return result;
        }
        else{
            System.out.println("its not a Rational");
            return null;
        }
    }


    
    public Rational mul(Object o){
        Rational result = new Rational();
            if(o.getClass()==Rational.class){
                Rational r = (Rational)o;
                result.mone=(mone*r.mone);
                result.mechane=mechane*r.mechane;
                return result;
            }
            else{
                System.out.println("its not a Rational");
                return null;
            }
    }



    public Rational div(Object o){
        Rational result = new Rational();
            if(o.getClass()==Rational.class){
                Rational r = (Rational)o;
                result.mone = mone*r.mechane;
                result.mechane = mechane*r.mone;
                return result;
            }
            else{
                System.out.println("its not a Rational");
                return null;
            }
    }


    
    public Rational clone() throws CloneNotSupportedException{
        return (Rational)super.clone();
    }

    
}
