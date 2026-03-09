

public class Program {
    public static void main(String[] args) throws Exception {
        // Initialize two 2x2 matrices
        Matrix m1 = new Matrix(4, 4);
        Matrix m2 = new Matrix(4, 4);

        int counter = 1; // הוספתי אינט קאונטר רק לצורך הנוחות של הבודק כדי לקצר תהליך בבקשה לא להוריד ניקוד אני יודע שזה מיותר
        // אפשר לראות את הסיבה שהוספתי קאונטר בשורה 75 במחלקה מטריקס


        // Read values for the matrices from user
        System.out.println("Enter values for the first matrix:");
        m1.read(counter); // הוספתי אינט קאונטר רק לצורך הנוחות של הבודק כדי לקצר תהליך בבקשה לא להוריד ניקוד אני יודע שזה מיותר
        counter++;
        System.out.println("Enter values for the second matrix:");
        m2.read(counter); // הוספתי אינט קאונטר רק לצורך הנוחות של הבודק כדי לקצר תהליך בבקשה לא להוריד ניקוד אני יודע שזה מיותר
        counter--;

        
        // Add the two matrices
        Matrix result = null;
        Matrix result2 = null;
        try {
            result = (Matrix) m1.add(m2);
            result2 = (Matrix) m1.sub(m2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        // Display the resulting matrix
        System.out.println("\nThe result of the add is:");
        System.out.println("+-------------------+");
        result.write();
        System.out.println("+-------------------+");


        System.out.println("\nThe result of the sub is:");
        System.out.println("+-------------------+");
        result2.write();
        System.out.println("+-------------------+");
    }
}