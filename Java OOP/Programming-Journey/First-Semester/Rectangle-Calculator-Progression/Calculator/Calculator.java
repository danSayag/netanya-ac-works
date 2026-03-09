public class Calculator {

    public int countDigits(int num) {
        int res = 0;
        while (num != 0) {
            res = res + 1;
            num = num / 10;
        }
        return res;
    }


    public boolean evenOdd(int num) {
        int odd = 0, even = 0;
        int temp;
        while (num != 0) {
            temp = num % 10;
            if (num % 2 == 0) {
                even = even + temp;
            } else {
                odd = odd + temp;
            }
            num = num / 10;
        }
        return even > odd;
    }


    public int getLastDigit(int num) {
        int res = 0;
        while (num > 0) {
            res = num;
            num = num / 10;
        }
        return res;
    }


    public int getDigit(int num, int k) {
        if (k == 0) {
            return num % 10;
        }
        for (int i = k; i != 0; i--) {
            num = num / 10;
        }
        return num % 10;
    }


    public int setDigit(int num, int k, int d) {
        int temp = 1;
        int tr = 0;
        for (int i = 0; i < k; i++) {
            temp = temp * 10;
        }
        tr = num / temp;
        tr = tr % 10;
        tr = tr * temp;
        temp = temp * d;
        return num - tr + temp;
    }


    public int getLastDigit2(int num) {
        int x = countDigits(num);
        x = x - 1;
        return getDigit(num, x);
    }


    public int getMinDigit(int num) {
        int min = num % 10, res = 0;
        while (num > 0) {
            int temp = num % 10;
            if (min == temp) {
                res++;
                num /= 10;
            }

            if (min > temp) {
                min = temp;
                res = 1;
                num /= 10;
            }
            if (temp > min) {
                num /= 10;
            }
        }
        return res;
    }


    public boolean inSymmetric(int num) {
        int temp = num;
        int ext = 0;
        for (int i = 0; i < countDigits(num); i++) {
            int x = temp % 10;
            ext = (ext * 10) + x;
            temp /= 10;
        }
        return ext == num;
    }
    

    public int search(int num, int d) {
        int res = 0;
        while (num > 0) {
            if (num % 10 == d) {
                res++;
            }
            num /= 10;
        }
        return res;
    }
}
