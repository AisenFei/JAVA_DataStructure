package Jian;

public class Offer64 {
    public int sumNums(int n) {
        return n == 1 ? n : n + sumNums(n - 1);
    }
}
