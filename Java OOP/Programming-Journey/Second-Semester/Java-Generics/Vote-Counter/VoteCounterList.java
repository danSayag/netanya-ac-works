import java.util.*;


public class List<T>{
    private T[] Vots;
    private int counter;


    public List(int size){
        Vots = (T[]) new Object[size];
        counter = 0 ;
    }


    public static int results(List[] vot, int hasima){
         
        String str = null;
        int res = 0 ;
        int temp = 0 ;

        for(int i = 0 ; i < vot.length ; i++){
            String nstr = vot[i].toString().toUpperCase();
            if(str==null){
              str=nstr;
            }
            if(nstr.equals(str)){
                temp++;
            }
        }
        return temp;


    }

    

















    public static void main(String[] args) {
        List<String> vots = (List<String>) Arrays.asList("BB","BB","Bb","aA","CCC","aa","cCc","aa","dddd","bb","bb");
    
        int x = results(vots , 2);
    
    }


    }