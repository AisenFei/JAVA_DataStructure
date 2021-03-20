package heap;

public class MyPriorityQueue {
    private Integer[] array;
    private int size;
    public MyPriorityQueue(){
        //简单起见，不考虑扩容
        array = new Integer[100];
        size = 0;
    }

    public Integer element(){
        if(size == 0){
            throw new RuntimeException("空了");
        }
        return array[0];
    }

    public Integer remove(){
        if(size == 0){
            throw new RuntimeException("空了");
        }
        int e = array[0];
        array[0] = array[size - 1];
        size--;
        adjustDown(0);
        return e;
    }

    //log(n)
    public void add(Integer e){
        array[size++] = e;
        adjustUp(size-1);
    }

    public void adjustUp(int index){
        while(index > 0){
            int parentIndex = (index - 1)/2;
            if(array[parentIndex] <= array[index]){
                return;
            }
            int t = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = t;

            index = parentIndex;
            parentIndex = (index - 1)/2;
        }
    }

    public void adjustDown(int index){
        int leftIndex = index * 2 + 1;
        while(leftIndex < size){
            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if(rightIndex < size && array[rightIndex] < array[leftIndex]){
                minIndex = rightIndex;
            }

            if(array[minIndex] >= array[index]){
                return;
            }

            int t = array[minIndex];
            array[minIndex] = array[index];
            array[index] = t;

            index = minIndex;
            leftIndex = index * 2 + 1;
        }
    }
}
