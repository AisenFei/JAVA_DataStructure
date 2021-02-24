package heap;

public class Heap {
    public static void adjustDown(int[] array,int size,int index){
        while(true) {
            //1.判断index对应的下标是不是叶子节点->如果是则直接return
            int leftIndex = index * 2 + 1;
            if (leftIndex >= size) {
                return;
            }

            //2.找到两个孩子中最小的
            int minIndex = leftIndex;
            int rightIndex = minIndex + 1;
            if (rightIndex < size && array[leftIndex] > array[rightIndex]) {
                minIndex = rightIndex;
            }

            //3.小孩子的值和index对应位置的值进行比较
            if (array[index] <= array[minIndex]) {
                return;
            }
            //4.交换小孩子的值和index的值
            int temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;

            //5.将minIndex视为index，继续执行
            index = minIndex;
        }
    }

    public static void createHeap(int[] array,int size){
        //找到层序遍历的最后一个结点下标;
        int lastIndex = size - 1;
        //找到该结点的父节点下标
        int lastParentIndex = (lastIndex - 1) / 2;
        //从[lastParentIndex, 0] 不断地向下调整
        for(int i=lastParentIndex;i >= 0;i--){
            adjustDown(array,size,i);
        }
    }
}
