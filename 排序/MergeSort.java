package code_2020_1125;

public class MergeSort {
    public static void mergeSort(int[] array){
          mergeSortInternal(array,0,array.length);
    }
    //区间范围是左闭右开的
    //array[lowIndex,highIndex)
    private static void mergeSortInternal(int[] array,int lowIndex,int highIndex){
        int size = highIndex - lowIndex;
        if(size <= 1){
            return;
        }

        int middleIndex = (lowIndex + highIndex) / 2;
        //左区间:[lowIndex,middleIndex)
        //右区间:[middleIndex,highIndex)
        mergeSortInternal(array,lowIndex,middleIndex);
        mergeSortInternal(array,middleIndex,highIndex);

        //左右两个区间都有序了，开始合并两个有序区间
        merge(array,lowIndex,middleIndex,highIndex);
    }
    //合并方法
    private static void merge(int[] array,int lowIndex,int middleIndex,int highIndex){
        int size = highIndex - lowIndex;
        int[] extraArray = new int[size];
        int leftIndex = lowIndex;
        int rightIndex = middleIndex;
        int extraIndex = 0;
        while(leftIndex < middleIndex && rightIndex < highIndex){
            if(array[leftIndex] <= array[rightIndex]){
                extraArray[extraIndex++] = array[leftIndex++];
            }else{
                extraArray[extraIndex++] = array[rightIndex++];
            }
        }
        if(leftIndex < middleIndex){
            while(leftIndex < middleIndex){
                extraArray[extraIndex++] = array[leftIndex++];
            }
        }else {
            while(rightIndex < highIndex){
                extraArray[extraIndex++] = array[rightIndex++];
            }
        }
        //将新数组搬回原数组
        for(int i = 0;i < size;i++){
            array[i + lowIndex] = extraArray[i];
        }
    }
}
