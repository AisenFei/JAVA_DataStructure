package Jian;

import java.util.ArrayList;
import java.util.List;

public class Offer57_2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1;
        int sum = 0;
        List<int[]> list = new ArrayList<>();
        while(i <= target/2){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                int[] arr = new int[j - i];
                for(int k = i;k < j;k++){
                    arr[k - i] = k;
                }
                list.add(arr);

                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
