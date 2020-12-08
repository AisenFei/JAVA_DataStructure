package Jian;

//leetcode剑指offer03.数组中的重复的数字
import java.util.HashSet;
import java.util.Set;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int re = -1;
        for(int num:nums){
            if(!set.add(num)){
                re = num;
                break;
            }
        }
        return re;
    }
}
