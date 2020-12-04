package code_2020_1203;

public class Person {
    String name;
    int age;
    int height;
    int weight;

    //重写toString方法，方便一会查看比较结果
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}' + '\n';
    }
}
