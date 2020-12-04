package code_2020_1203;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JDKListSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(8);
        list.add(4);
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
}
