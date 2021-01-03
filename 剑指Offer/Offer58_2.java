package Jian;
//左旋转字符串，substring可以分割字符串，左闭右开。
public class Offer58_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }
}
