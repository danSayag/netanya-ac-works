public class Utility{

    public static void showAll(Showable[] a){ 
        for (int i = 0 ; i < a.length ; i++ ){
            a[i].show();
        }
    }


    public static void showAll(Object[] a){ 
        for(int i = 0 ; i < a.length ; i++){
             if( a[i] instanceof Showable){
              ((Showable)a[i]).show();
            }
            else{
                System.out.println(a[i]);
            }
        }
    }

    public boolean equals(Object o ){
        if(o.getClass()==getClass()){
            if(super.equals(o)){
                return true;
            }
        }
        return false;
    }


    
    public static boolean search(Object[] a, Object o){
        if(o==null || a.length==0){
            return false;
        }

        for(int i = 0 ; i<a.length ; i++){
            if(a[i] instanceof Comparable){
                if(((Comparable)a[i]).compareTo(o)==0){
                    return true;
                }
            }
        }
    return false;  
    }



    public static Object max(Object[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        Object max = a[0];
        if (!(max instanceof Comparable)) {
            return null;
        }

        for (int i = 1; i < a.length; i++) {
            Object current = a[i];
            if (!(current instanceof Comparable)) {
                return null;
            }

            Comparable comp = (Comparable) current;
            if (comp.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }   


    }





