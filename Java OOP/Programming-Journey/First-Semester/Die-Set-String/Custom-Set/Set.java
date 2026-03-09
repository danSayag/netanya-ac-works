public class Set {
    private int[] allSets;
    private int counter;

    public Set(int num){
        this.allSets = new int[num];
        counter = 0;
    }

    public boolean add(int num){
        if(counter == allSets.length){
            return false;
        }
        for(int i = 0 ; i < counter ; i++){
            if(num == allSets[i]){
                return false;
            }
        }
        allSets[counter++] = num;
        return true;
    }


    public int find(int num){
        for(int i = 0 ; i < allSets.length ; i++){
            if(num == allSets[i]){
                return i;
            }
        }
        return -1;
    }


    public void show(){
        System.out.print("(");
        for(int i = 0 ; i < counter ; i++){
            System.out.print(allSets[i]);
            if(i < counter -1){
                System.out.print(",");
            }
        }
        System.out.println(")");
    }


    public boolean isEmpty(){
        if(counter == 0 ){
            return true;
        }
        return false;
    }


    public boolean isFull(){
        if(counter == allSets.length){
            return true;
        }
        return false;
    }

    public boolean remove(int numToRemove){
        int index = find(numToRemove);
        if(index != -1){
            for(int i = index ; i <counter - 1 ; i++){
                allSets[i] = allSets[i + 1];
            }
            counter--;
            return true;
        }
        return false;
    }







}
