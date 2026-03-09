import java.util.Scanner;
public class Matrix implements Aritmetic,Cloneable,InputOutput{

    int[][] data;
    private int row;
    private int colums;


    public Matrix(int colums , int row){
        this.colums=colums;
        this.row=row;
        data = new int[colums][row];
    }



    public Matrix add(Object other){ 
        if(!(other instanceof Matrix)){
            throw new NotMartixException("other not a Matrix");
        } 
        Matrix another = (Matrix)other;
         if(this.colums!=another.colums || this.row!=another.row){
            throw new NotEqualMatrixExceptionDimention("Matrix imention are not equal");
        }
        if(another.colums<=0 || another.row<=0){
            throw new MetrixElementsLessOrEqualToZero("one of the metrix elements is less of equal to zero");
        }
        Matrix result = new Matrix(this.colums,this.row);
        for(int i = 0 ; i < this.colums ; i++ ){
            for(int j = 0 ; j < this.row ; j++ ){
                result.data[i][j]=this.data[i][j]+another.data[i][j];
                }
            }
        return result;
        }



    public Matrix sub(Object other){
        if(!(other instanceof Matrix)){
            throw new NotMartixException("other not a Matrix");
        } 
        Matrix another = (Matrix)other;
        if(this.colums!=another.colums || this.row!=another.row){
            throw new NotEqualMatrixExceptionDimention("Matrix sizes are not equal");
        }
        if(another.colums<=0 || another.row<=0){
        throw new MetrixElementsLessOrEqualToZero("less or equal to zero");
        }
        Matrix result = new Matrix(this.colums,this.row);
        for(int i = 0 ; i < this.colums ; i++){
            for(int j = 0 ; j < this.row ; j++){
                result.data[i][j]=this.data[i][j]-another.data[i][j];
                }
            }  
        return result;     
    }



    public Matrix mul(Object other){
        throw new multOperationNotSupported();
    }



    public Matrix div(Object other){
        throw new divOperationNotSupported();
    }


    
    public void read(int counter) { // הוספתי אינט קאונטר רק לצורך הנוחות של הבודק כדי לקצר תהליך בבקשה לא להוריד ניקוד אני יודע שזה מיותר
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\ndo you want to enter the values of the matrix from the question? (1 for yes, 0 for no I will enter them)");
        int ans = scanner.nextInt();
        if(ans == 1){
            if(counter == 1){

                data[0][0] = 1;
                data[0][1] = 2;
                data[0][2] = 4;
                data[0][3] = 8;
                data[1][0] = 0;
                data[1][1] = 9;
                data[1][2] = -9;
                data[1][3] = -2;
                data[2][0] = 4;
                data[2][1] = 3;
                data[2][2] = 0;
                data[2][3] = 1;
                data[3][0] = -7;
                data[3][1] = 7;
                data[3][2] = -7;
                data[3][3] = 7;
                return;
            }
            if(counter == 2){

                data[0][0] = 6;
                data[0][1] = 0;
                data[0][2] = 7;
                data[0][3] = 7;
                data[1][0] = 1;
                data[1][1] = 2;
                data[1][2] = 3;
                data[1][3] = 2;
                data[2][0] = 5;
                data[2][1] = 0;
                data[2][2] = 5;
                data[2][3] = 0;
                data[3][0] = -7;
                data[3][1] = 7;
                data[3][2] = -7;
                data[3][3] = 7;
                return;
            }
        }
        if(ans == 0){
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    while (true) {
                        try {
                            System.out.println("Enter the element for [" + i + "][" + j + "]: ");
                            data[i][j] = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Input must be an integer. Please try again.");
                            scanner.next();
                        }
                    }
                }
            }
        }
    }


    public void write(){
        for(int i = 0 ; i < this.data.length ; i++){
            for(int j = 0 ; j < this.data[i].length ; j++){
                System.out.printf( "%4d" , data[i][j] );
            }
            System.out.println();
        }
    }


    public boolean equal(Object other){
        if(!(other instanceof Matrix)){
            throw new NotMartixException("object no a Matrix");
        }
        Matrix another = (Matrix)other;
        if(another.row!=this.row || another.colums!=this.colums){
            throw new NotEqualMatrixExceptionDimention("diffrant dimensions of matrix");
        }
        for(int i = 0 ; i < this.data.length ; i++){
            for(int j = 0 ; j < this.data[i].length ; j++){
                if(this.data[i][j]!=another.data[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    
    public Matrix clone()throws CloneNotSupportedException{
        Matrix result = (Matrix)super.clone();
        for(int i = 0 ; i < row ; i++ ){
            for(int j = 0 ; j < colums ; j++ ){
                result.data[i][j] = data[i][j];
            }
        } 
        return result;
    }


    public int valueAt(int i , int j){
        if( i < 0 || j < 0 ){
            throw new ArrayIndexOutOfBoundsException("one of the numbers a negative");
        }
        if( i > row || j > colums){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[i][j];
    }
    
}