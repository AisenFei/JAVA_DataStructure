package code_2021_0113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> courses  = new ArrayList<>();
        courses.add("c语言");
        courses.add("JavaSE");
        courses.add("JavaWeb");

        //允许插入重复元素
        courses.add("c语言");

        //按照添加顺序打印
        System.out.println(courses);

        //类似数组下标的方式访问
        System.out.println(courses.get(0));

        System.out.println(courses);
        courses.set(0,"计算机基础");
        System.out.println(courses);

        //截取部分[1,3)
        List<String> subCourses = courses.subList(1,3);
        System.out.println(subCourses);

        //重新构造成链表
        List<String> courses2 = new LinkedList<>(courses);
        System.out.println(courses2);

        //引用转换，别忘了强转
        ArrayList<String> courses3 = (ArrayList<String>)courses;
        System.out.println(courses3);
    }
}
