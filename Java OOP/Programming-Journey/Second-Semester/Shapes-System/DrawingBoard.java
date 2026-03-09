public class drawingBoard {

    private shapes[] allShapes;
    private int counter;


    public drawingBoard(int a){
        allShapes=new shapes[a];
        counter = 0;
    }

    
    public void add(shapes...sh){
            int numShapesToAdd = sh.length;
            int newCounter = counter + numShapesToAdd;
            if (newCounter > allShapes.length) {
                int newSize = (int) (newCounter * 1.5);
                shapes[] newShapes = new shapes[newSize];
                System.out.println("This new drawing board size is: " + newSize);
                for (int i = 0; i < counter; i++) {
                    newShapes[i] = allShapes[i];
                }
                allShapes = newShapes;
            }
            int Index = counter;
            for (int i = 0; i < numShapesToAdd; i++) {
                allShapes[Index] = sh[i];
                Index++;
            }
            counter = newCounter;
        }
        


    public void showAll(){
        for(int i = 0 ; i < allShapes.length ;i++ ){
            if(allShapes[i]!=null){
            allShapes[i].show();
            }
        }
    }


    public shapes getMax(){
        int max=0;
         for(int i = 0 ; i < counter ; i++){
            if(allShapes[i].compare(allShapes[max])==1){
                max=i;
            }
         }
      return allShapes[max];
    }
    

    public shape3D getMax3DV1(){
        int max = 0;
        boolean a = false;
        for(int i = 0 ; i < allShapes.length ; i++){
            if(allShapes[i] instanceof shape3D){
                a=true;
                if(allShapes[i].compare(allShapes[max])==1){
                    max=i;
                }
                    if(allShapes[i].compare(allShapes[max])==0){
                        max=i;
                    }
            }
        }
            if(a)
                return (shape3D)allShapes[max];
            
        return null;
    }


    public shape3D getMax3DV2(){
        int max = 0;
        boolean a = false;
        for(int i = 0 ; i < allShapes.length ; i++){
            if(allShapes[i]!=null){
                if(allShapes[i].getClass()==ball.class||allShapes[i].getClass()==cube.class){
                    a=true;
                    if(allShapes[i].compare(allShapes[max])==1||allShapes[i].compare(allShapes[max])==0){
                        max=i;
                    }
                }
            }  
        }
        if(a)
            return (shape3D)allShapes[max];

    return null;
    }
    
    public Class[] getTypes() {
        Class[] types = new Class[counter];
        int index = 0;
        for (int i = 0; i < counter; i++) {
            boolean isTypeFound = false;
            for (int j = 0; j < index; j++) {
                if (types[j] == allShapes[i].getClass()) {
                    isTypeFound = true;
                    break;
                }
            }
            if (!isTypeFound) {
                types[index] = allShapes[i].getClass();
                index++;
            }
        }
        Class[] result = new Class[index];
        for (int i = 0; i < index; i++) {
            result[i] = types[i];
        }
        return result;
    }

} 
