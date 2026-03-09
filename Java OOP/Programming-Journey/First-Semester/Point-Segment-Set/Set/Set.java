import java.lang.module.ResolutionException;

public class Set {
    private int size;
    private int index;
    private int[] set;


    public Set(){
        size = 10;
        index = 0 ;
        set = new int[size];
    }


    public Set(int size){
        this.size = size;
        index = 0;
        set = new int[size];
    }


    public Set(int... a){
        index = 0;
        set = new int[a.length];
        size = a.length;
        if(a.length>=2){
            for (int i : a) {
                add(i);
            }
        }
       
    }


    public Set(Set st){
        size = st.size;
        index = st.index;
        set = new int[st.size];
        for(int i = 0 ; i < index ; i++){
            set[i] = st.set[i];
        }
    }


    public int getIndex(){
        return index;
    }

    public void show(){
        for (int i = 0 ; i < index ; i++){
            System.out.print(set[i] + " ");
        }
        System.out.println();
    }


    public boolean equals(Set st){
        int counter = 0 ;
        if(st.index != index){
            return false;
        }
        for(int i = 0 ; i < index ; i++){
            for(int j = 0 ; j < index ; j++){
                if(st.set[i] == set[j]){
                    counter++;
                }
            }
        }
        return counter == index;
    }

    
    public boolean add(int a){
        if(index == set.length){
            return false;
        }
        for(int i = 0 ; i < index ; i++){
            if(a == set[i]){
                return false;
            }
        }
        set[index++] = a;
        return true;
    }


    public int getSize(){
        return size;
    }



    public Set union(Set st){
        Set res = new Set(getSize()+st.getSize());
        for(int i = 0 ; i < index + st.index ; i++ ){
            if( i < index){
                res.add(set[i]);
            }
            else{
            res.add(st.set[i-index]);
        }
    }
        return res;
    }



    public int large(Set st){
        if(st.index >= index){
            return st.index;
        }
        return index;
    }
    

    public boolean exist(int a){
        for(int i = 0 ; i < index ; i++){
            if(set[i]==a){
                return true;
            }
        }
        return false;
    }

    public Set intersect(Set st){
        int a = large(st);
        Set res = new Set(a);
        for(int i = 0 ; i < a; i++){
            if(exist(st.set[i])){
                res.add(st.set[i]);
            }
        }
        return res;
        
    }

    public boolean subset(Set other) {
        for (int i = 0; i < this.index; i++) {
            if (!other.exist(this.set[i])) {
                return false;
            }
        }
        return true;
    }

    public int[] toArray() {
        int[] result = new int[this.index];
        for (int i = 0; i < this.index; i++) {
            result[i] = this.set[i];
        }
        return result;
    }

    public Set subtract(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.index; i++) {
            if (!other.exist(this.set[i])) {
                result.add(this.set[i]);
            }
        }
        return result;
    }

    
}

    

