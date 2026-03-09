public class Progression {
    private int first, jump;

    public Progression(int first, int jump) {
        this.first = first;
        this.jump = jump;
    }


    public Progression() {
        first = -3;
        jump = 2;
    }


    public int getElement(int k) {
        int x = first;
        for (int i = 1; i < k; i++) {
            x += jump;
        }
        return x;
    }


    public void showProg(int n) {
        int x = first;
        for (int i = 1; i < n; i++) {
            System.out.print(x);
            x += jump;
            if (i != n) {
                System.out.print(",");
            }
        }
        System.out.println(x);
    }


    public void showProg() {
        int x = first;
        for (int i = 1; i < 10; i++) {
            System.out.print(x);
            x += jump;
            if (i != 10) {
                System.out.print(",");
            }
        }
        System.out.println(x);
    }


    public void showProgUpTo(int n) {
        int x = first;
        while (x < n) {
            System.out.print(x);
            x += jump;
            if (x < n) {
                System.out.print(",");
            }
        }
        System.out.println();
    }


    public int sum(int n) {
        int res = first;
        int x = first;
        for (int i = 1; i < n; i++) {
            if (i != n) {
                res += x + jump;
                x += jump;
            }
        }
        return res;
    }
}