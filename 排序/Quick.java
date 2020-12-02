package code_2020_1125;

public class Quick {
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length - 1);
    }
    private static void quickSortInternal(int[] array,int lowIndex,int highIndex){
        //由于是闭区间，所以，区间内个数需要加1
        int size = highIndex - lowIndex + 1;
        if(size <= 1){
            return;
        }
        //选择其中一个数（选最左边）--array[lowIndex]
        //执行partition，小的放左边，大的放右边
        //keyIndex 是经过partition之后，选出来的数最终所在下标
        int keyIndex = partitionHoare(array,lowIndex,highIndex);
        //分别对左右区间进行相同处理--递归
        quickSortInternal(array,lowIndex,keyIndex - 1);
        quickSortInternal(array,keyIndex + 1,highIndex);
    }

    //1.选择array[lowIndex]作为特殊的数
    //2.需要遍历整个区间（不能遗漏任何数）和选出来的数进行比较
    //3.保证 小于等于的放在左边，大于等于的放在右边（没有顺序要求）
    //Hoare法
    private static int partitionHoare(int[] array,int lowIndex,int highIndex){
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        //选择最左边的数
        int key = array[lowIndex];
        //选择了最左边的，让右边先走

        //停止条件leftIndex == rightIndex
        //循环的继续条件 leftIndex < rightIndex
        int temp;
        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] >= key){
                rightIndex--;
            }
            //说明[rightIndex]遇到了小的了
            while(leftIndex < rightIndex && array[leftIndex] <= key){
                leftIndex++;
            }
            //说明[leftIndex]遇到了大的了

            temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
        }
        //交换选出的数和leftIndex与rightIndex共同指向的数
        temp = array[lowIndex];
        array[lowIndex] = array[leftIndex];
        array[leftIndex] = temp;
        return leftIndex;
    }

    public static int partitionWaKeng(int[] array,int lowIndex,int highIndex){
        int leftIndex = lowIndex;
        int rightIndex = highIndex;

        int key = array[lowIndex];

        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] >= key){
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];
            while(leftIndex < rightIndex && array[leftIndex] >= key){
                leftIndex++;
            }
            array[rightIndex] = array[leftIndex];
        }
        array[leftIndex] = key;
        return leftIndex;
    }
}
