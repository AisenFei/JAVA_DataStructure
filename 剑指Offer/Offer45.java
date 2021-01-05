package Jian;

import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {
    public String minNumber(int[] nums){
        //1.整形数组转换为字符串数组
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        //2.按照需求进行排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //这里我们需要按照自己的需求来重写compare方法
                //String底层本身就实现了Comparable，所以我们调用它的compareTo方法即可。
                return (o1+o2).compareTo(o2+o1);
            }
        });

        //也可以直接写成lambda表达式形式。
        /*Arrays.sort(strs,(s1,s2)->(s1+s2).compareTo((s2+s1)));*/

        //3.拼接字符串
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }
}
