package Jian;

public class Offer17 {
    public int[] printNumbers(int n) {
        int len = (int)(Math.pow(10,n)-1);
        int[] arr = new int[len];
        for(int i = 0;i < arr.length;i++){
            arr[i] = i+1;
        }
        return arr;
    }
}
