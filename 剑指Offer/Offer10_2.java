package Jian;
//剑指 Offer 10- II. 青蛙跳台阶问题
public class Offer10_2 {
    public int numWays(int n) {
        if( n == 0 || n == 1) return 1;
        int a = 1,b = 1,c = a+b;
        for(int i = 2;i <= n;i++){
            a = b%1000000007;
            b = c%1000000007;
            c = a + b;
        }
        return b;
    }
}
