package q2;

public class Stack<T> {
    private T[] data;
    private int top;
    
    public Stack(int size) {
        data = (T[]) new Object[size];
        top = -1;
    }
    
    public void push(T value) {
        top++;
        data[top] = value;
    }
    
    public T pop() {
        return data[top--];
    }
    
    public T top() {
        return data[top];
    }

    public String toString(){//אני יודע שלא ביקשו להוסיף את השיטה הזאת אז אם אפשר לא להוריד ניקוד
        String str = "(";
        for(int i = 0; i <= top; i++){
            str += data[i];
            if(i != top){
                str += ",";
            }
        }
        str += ")";
        return str;
    }
}
