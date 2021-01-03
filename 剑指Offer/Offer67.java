package Jian;

//把字符串转换成整数
public class Offer67 {
    public int strToInt(String str){
        char[] arr = str.trim().toCharArray();
        if(arr.length == 0) return 0;
        int res = 0,sign = 1;
        int i = 1,flag = Integer.MAX_VALUE/10;
        if(arr[0] == '-'){
            sign = -1;
        }else if(arr[0] != '+'){
            i = 0;
        }
        for(int j = i;j < arr.length;j++){
            if(arr[j] < '0' || arr[j] > '9')return 0;
            //当res>flag时，说明res后面再加就超范围了（后一位已经是数字了）
            //当res==flag时，如果后一位大于7则超范围，正好把负数的情况也包含进去了
            //负数最后一位是8，那么大于7，也可以按照边界值输出。
            if(res > flag || res == flag && arr[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + (arr[j] - '0');
        }
        return res*sign;
    }
}
