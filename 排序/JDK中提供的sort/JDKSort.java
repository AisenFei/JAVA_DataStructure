package code_2020_1203;

import java.util.*;

public class JDKSort {
    //定义一个名字数组，方便一会初始化person.name
    private static String[] names = {"曹操","关羽","张飞","刘备","赵云",
            "诸葛亮","黄忠","周瑜","小乔","吕布"};

    //创建person类数组，构建随机person对象
    private static Person[] createPersonArray(){
        Person[] personArray = new Person[10];
        for(int i = 0;i < 10;i++){
            personArray[i] = new Person();
        }
        //将定义的名字数组转换成list，调用Collections的shuffle（洗牌）方法
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        Collections.shuffle(nameList);
        Random random = new Random();
        for(int i = 0;i < 10;i++){
            personArray[i].name = nameList.remove(0);
            personArray[i].age = random.nextInt(30) + 5;
            personArray[i].height = random.nextInt(100) + 100;
            personArray[i].weight = random.nextInt(100) + 100;
        }
        return personArray;
    }
    public static void main(String[] args) {
        //创建是个随机person对象
        Person[] personArray = createPersonArray();
        System.out.println(Arrays.toString(personArray));

        //先尝试用年龄进行比较，从小到大排序
        Arrays.sort(personArray, new Comparator<Person>() {
            //传入一个匿名比较器，并重写compare方法
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(Arrays.toString(personArray));
    }

}
