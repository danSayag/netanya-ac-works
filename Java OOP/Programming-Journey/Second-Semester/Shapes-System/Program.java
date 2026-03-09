public class program {
    

    public static void main(String[] args) {
        ball b = new ball(7);
        circle c = new circle(6);
        rectangle rc = new rectangle(7, 4);
        triangle tr = new triangle(4 , 6);
        ball b1 = new ball(7);
        circle c1 = new circle(9);
        triangle tr1 = new triangle( 5, 6);
        triangle tr2 = new triangle( 5, 6);
        triangle tr3 = new triangle( 5, 6);
        triangle tr4 = new triangle( 5, 6);
    

        drawingBoard dBoard=new drawingBoard(5);
        dBoard.add(c,b,c1);
        dBoard.showAll();
        System.out.println();
        dBoard.add(c,rc,b1,tr2,tr3,tr4);
        System.out.println();
        dBoard.showAll();

        System.out.println();
        System.out.println("area of ball b "+b.area());
        System.out.println("area of tringle tr1 "+tr1.area());
        System.out.println(b.compare(tr1));
        System.out.println("area of ball b1 "+b1.area());
        System.out.println(b.compare(b1));
        System.out.println(tr1.compare(b));

        System.out.println();
        System.out.println(dBoard.getMax().area());

        System.out.println("v1");
        System.out.println(dBoard.getMax3DV1().area());

        System.out.println("v2");
        System.out.println(dBoard.getMax3DV2().area());
        
        System.out.println(b.equals(b1));
        System.out.println(b.equals(c));
        System.out.println(tr.equals(tr1));
        dBoard.getTypes();
        System.out.println();
        Class[] types = dBoard.getTypes();
        System.out.println("Types of objects on the drawing board:");
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
        }

       

        
}
}

