package Jian;

import java.util.HashMap;

public class Offer50 {
    public char firstUniqChar(String s) {
        HashMap<Character,Boolean> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for(char c : charArr){
            map.put(c,!map.containsKey(c));
        }
        for(char c : charArr){
            if(map.get(c)) return c;
        }
        return ' ';
    }
}
