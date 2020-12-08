package Jian;
//剑指Offer05.替换空格
public class Offer05 {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length*3];
        int size = 0;
        for(int i = 0;i < length;i++){
            char c = s.charAt(i);
            if(c != ' '){
                array[size++] = c;
            }else{
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }
        }
        String newString = new String(array,0,size);
        return newString;
    }
}
