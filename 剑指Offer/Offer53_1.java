package Jian;

//在排序数组中查找数字1
public class Offer53_1 {
    public int search(int[] nums,int target){
        return find(nums,target) - find(nums,target- 1);
    }
    public int find(int[] nums,int target){
        int i = 0,j = nums.length - 1;
        while(i <= j){
            int m = (j + i) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
