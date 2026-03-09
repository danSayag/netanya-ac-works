public class Die {
    private int numOfSides;
    private int[] statistics;
    private int lastToss;
    
    public Die(){
        this(6);
    }
    
    
    public Die(int n){
        numOfSides = n;
        statistics = new int[numOfSides];
        lastToss = 0;
    }
    
    
    public int rollDie(boolean unique){
        int result = 0;
        if(unique){
            while (true) {
                result = 1 + (int)(Math.random()*numOfSides);
                if(lastToss != result){
                    statistics[result - 1]++;
                    lastToss = result;
                    break;
                }
            }
        }
        else{
            result = 1 + (int)(Math.random()*numOfSides);
            statistics[result - 1]++;
            lastToss = result;
        }
        return result;
        
    }
    
    public void showStatistics(){
        int k;
        for(k = 0 ; k < numOfSides ; k++)
            System.out.println(k + 1 + ":" + statistics[k]);
            System.out.println("Most frequent digit is " + getMostFrequent());
    }
    
    
    private int getMostFrequent(){
        int max = 0;
        int mostFrequent = 0;
        for(int i = 0; i < statistics.length ; i++){
            if(max < statistics[i]){
                max = statistics[i];
                mostFrequent = i + 1;
            }
        }
        return mostFrequent;
    }
    
    public int[] getAllMostFrequents(){
        int howManyFrequent = 0;
        int mostFrequent = getMostFrequent();
        for(int i = 0 ; i < statistics.length ; i++){
            if(statistics[i] == statistics[mostFrequent - 1]){
                howManyFrequent++;
            }
        }
        int[] moreThanOne = new int[howManyFrequent];
        if(howManyFrequent > 1){
            howManyFrequent = 0;
            for(int i = 0 ; i < statistics.length ; i++){
                if(statistics[i] == statistics[mostFrequent - 1]){
                    moreThanOne[howManyFrequent++] = i+1;
                }
            }
        } 
        return moreThanOne;
    }





}
