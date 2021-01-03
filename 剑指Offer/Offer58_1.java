package Jian;
//翻转单词顺序，trim()可以去字符串收尾空格。
public class Offer58_1 {
    public String reverseWords(String s) {
        String[] strArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length - 1;i > 0;i--){
            //注意：如果字符串中间出现了连续空格，则会产生空字符串。
            if(strArr[i].equals(""))continue;
            sb.append(strArr[i]+" ");
        }
        sb.append(strArr[0]);
        return sb.toString();
    }
}
