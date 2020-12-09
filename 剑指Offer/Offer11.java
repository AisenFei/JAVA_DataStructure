package Jian;
//剑指Offer11.旋转数组的最小数字
public class Offer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int point = left + (right - left)/2;
            if(numbers[point] < numbers[right]){
                right = point;
            }else if(numbers[point] > numbers[right]){
                left = point + 1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}
