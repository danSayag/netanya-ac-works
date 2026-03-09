public class Set implements Arithmetic,ScanOp {

    private Object[] allSet;
    private int size;
    private int counter;

    public Set(int size, Object...o){
        this.size = size;
        allSet = new Object[size];
        counter = 0 ;
        for(Object obj : o){
            addTo(obj);
        }
    }



    public boolean addTo(Object o){
        for(int i = 0 ; i < allSet.length ; i++){
            if(allSet[i] == null){
                if(!exist(o)){
                allSet[counter++]=o;
                   return true; 
                }
            }
        }
        return false;
    }
    


    public boolean exist(Object o){
        for(int i = 0 ; i < allSet.length ; i++ ){
            if(allSet[i]!=null){
                if(allSet[i].equals(o)){
                    return true;
                }
            }
        }
        return false;
    }


    public int countObject(Object[] o,Class c){
        int count = 0 ;

        for(int i = 0 ; i < allSet.length ; i++){
            if(allSet[i]==null){
                return count;
            }
               if(o[i].getClass()==c){
                count++; 
            }
        }
        return count;
    }
    


    public String toString(){
        String result="";
        int count = 0 ;

        for(int i = 0 ; i < counter ; i++){
            Class c = allSet[i].getClass();
            count++;
            result +=c.getSimpleName() +"("+ countObject(allSet, c) + ")" ;
                if(count<counter){
                    result+=":";
                }
        }
        return result;
    }


    public Arithmetic add(Arithmetic a) {
        Set other = (Set) a;
        Set another = new Set(size + other.size);

        for (int i = 0; i < counter; i++) {
            another.addTo(allSet[i]);
        }
        for (int i = 0; i < other.counter; i++) {
            another.addTo(other.allSet[i]);
        }
        return another;
    }


    public Arithmetic sub(Arithmetic a) {
        Set other = (Set) a;
        Set another = new Set(size + other.size);

        for(int i = 0; i < counter; i++){
            if(!other.exist(another)){
                another.addTo(allSet[i]);
            }
        }
        return another;
    }


    public Arithmetic mul(Arithmetic a) {
        Set other = (Set) a;
        Set another = new Set(Math.min(size, other.size));

        for(int i = 0; i < counter; i++){
            if(other.exist(allSet[i])){
                another.addTo(allSet[i]);
            }
        }
        return another;
    }


    public Arithmetic div(Arithmetic a) {
        return null;
    }


    
    public static Object[] sameClass(Object[] o, Class c){//עשינו עם קרן
        int count = 0 ;
        for(int i = 0 ; i < o.length ; i++){
            if(o[i].getClass()==c){
                count++;   
            }
        }
        Object[] sameClass = new Object[count];
        int k = 0 ; 
        for(int i = 0 ; i < o.length ; i++)
            if(o[i].getClass()==c)
                sameClass[k++]=o[i];
        return sameClass;
    }


    public Object[] getObjectsByType(Class<?> clazz) {
        int count = 0;
    
        for (int i = 0; i < counter; i++) {
            if (allSet[i].getClass().equals(clazz)) {
                count++;
            }
        }
        Object[] objects = new Object[count];
        int currentIndex = 0;

        for (int i = 0; i < counter; i++) {
            if (allSet[i].getClass().equals(clazz)) {
                objects[currentIndex++] = allSet[i];
            }
        }
    
        return objects;
    }

    
    public Class<?>[] getDistinctClasses() {
        Class<?>[] tempClasses = new Class<?>[counter];
        int distinctCount = 0;
    
        for (int i = 0; i < counter; i++) {
            Class<?> clazz = allSet[i].getClass();
            boolean classExists = false;
            for (int j = 0; j < distinctCount; j++) {
                if (tempClasses[j].equals(clazz)) {
                    classExists = true;
                    break;
                }
            }
            if (!classExists) {
                tempClasses[distinctCount++] = clazz;
            }
        }
        Class<?>[] distinctClasses = new Class<?>[distinctCount];
        System.arraycopy(tempClasses, 0, distinctClasses, 0, distinctCount);
    
        return distinctClasses;
    }

    private int cIndex = -1;

    public void reset() {
        cIndex = -1;
    }

    public boolean forward() {
        if (cIndex + 1 < counter) {
            cIndex++;
            return true;
        }
        return false;
    }

    public boolean backward() {
        if (cIndex > 0) {
            cIndex--;
            return true;
        }
        return false;
    }

    public Object getCurrent() {
        if (cIndex >= 0 && cIndex < counter) {
            return allSet[cIndex];
        }
        return null;
    }
    
}