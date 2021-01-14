package code_2021_0113;

import java.util.Arrays;
import java.util.List;

//手写ArrayList类
public class ArrayList {
    private  int[] array;//顺序表内部的数组
    private int size; //顺序表内部的元素个数

    public ArrayList(){
        //初始容量是10个
        array = new int[10];
        //初始的元素个数是0个
        size = 0;
    }

    public ArrayList(List o){
        array = new int[o.size()];
        for(int i = 0; i < o.size();i++){
            array[i] = (int)o.get(i);
        }
        size = o.size();
    }

    //平时时间复杂度是O(1)
    //碰到需要扩容了，时间复杂度是O(n)
    //由于扩容的情况比较少见，所以，这个方法的时间复杂度一般被称为平均O(1)
    public boolean add(Integer e){
        if(array.length == size){
            //扩容
            ensureCapacity(array.length*2);
        }
        array[size++] = e;
        return true;
    }

    //调用完这个方法后，保证容量一定是 >= capacity
    //时间复杂度是O(n)
    public void ensureCapacity(int capacity) {
        //检查是否需要扩容
        if(this.array.length >= capacity){
            return;
        }

        //定义新数组
        int[] newArray = new int[capacity];
        //2.进行搬家，从array数组中搬到newArray数组中
        for(int i = 0;i < size;i++){
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    public void add(int index,Integer e){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("不合法的下标："+index);
        }

        if(array.length == size){
            ensureCapacity(array.length*2);
        }

        //要把index及之后的所有元素，全部向后搬移
        //为了保证元素不被覆盖，从后往前搬

        for(int i = size; i > index;i--){
            array[i] = array[i-1];
        }
        array[index] = e;
        size++;
    }

    public Integer remove(int index){
        if(index < 0||index >= size){
            throw new IndexOutOfBoundsException("不合法的下标："+index);
        }

        int e = array[index];

        //从前往后删
        for(int i = index + 1;i < size;i++){
            array[i-1] = array[i];
        }
        size--;
        return e;
    }

    public boolean remove(Integer e){
        int index = indexOf(e);
        if(index != -1){
            remove(index);
            return true;
        }else{
            return false;
        }
    }

    public Integer get(int index){
        if(index < 0||index >= size){
            throw new IndexOutOfBoundsException("不合法下标："+index);
        }

        return array[index];
    }

    public Integer set(int index,Integer e){
        if(index < 0||index >= size){
            throw new IndexOutOfBoundsException("不合法下标："+index);
        }
        Integer old = array[index];
        array[index] = e;
        return old;
    }

    public int size(){
        return size;
    }

    public void clear(){
        Arrays.fill(array,-1);
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Integer e){
        return indexOf(e) != -1;
    }

    public int indexOf(Integer e){
        for(int i = 0;i < size;i++){
            if(array[i] == e){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer e){
        for(int i = size - 1;i >= 0;i--){
            if(array[i] == e){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0;i < size;i++){
            sb.append(array[i]);
            if(i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
