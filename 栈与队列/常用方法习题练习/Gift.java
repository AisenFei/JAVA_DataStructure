package code_2021_0119;

import java.util.HashMap;
import java.util.Map;

public class Gift {
    public static void main(String[] args) {
        int[] gifts = new int[]{1,2,3,2,2};
        System.out.println(getValue(gifts,5));
    }
    public static int getValue(int[] gifts, int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int key : gifts){
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int num = n%2 == 0 ? n/2 : n/2+1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() >= num){
                return entry.getKey();
            }
        }
        return 0;
    }
}
