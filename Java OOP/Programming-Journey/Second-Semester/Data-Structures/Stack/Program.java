package q2;

public class Program {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>(5);
        st.push(1);
        st.push(2);
	    st.push(3);
        st.push(4);
        st.push(5);
        System.out.println(st);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        System.out.println(st);
        Stack<String> st2 = new Stack<>(5);
        st2.push("dan");
        st2.push("hello");
        st2.push("bike");
        System.out.println(st2);
        System.out.println(st2.top());
        st2.pop();
        System.out.println(st2.top());
        st2.pop();
        System.out.println(st2.top());
    


        
    }
       
    
}
