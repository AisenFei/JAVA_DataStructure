package Jian;
//剑指 Offer 10- I. 斐波那契数列
public class Offer10_1 {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0,b = 1,c = a + b;
        for(int i = 2;i <= n;i++){
            a = b%1000000007;
            b = c%1000000007;
            c = a + b;
        }
        return b;
    }
}
