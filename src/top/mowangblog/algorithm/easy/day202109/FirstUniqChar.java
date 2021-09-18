package top.mowangblog.algorithm.easy.day202109;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Algorithm-Daily-practice
 * 字符串中的第一个唯一字符
 *
 * @author : Xuan Li
 * @date : 2021-09-18 09:35
 **/
@SuppressWarnings("all")
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if(s.length() <= 1){
            return 0;
        }
        //使用数组计数
//        int[] arr = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            arr[s.charAt(i) - 'a']+=1;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (arr[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
        //通过字符串方法判断
//        for (int i = 0; i < s.length(); i++) {
//            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
//                return i;
//            }
//        }
//        return -1;
        //通过hash表计数
//        HashMap<Character, Integer> map = new LinkedHashMap<>(s.length());
//        for (int i = 0; i < s.length(); i++) {
//            int num = map.getOrDefault(s.charAt(i),0) + 1;
//            map.put(s.charAt(i),num);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if(map.get(i) == 1){
//                return i;
//            }
//        }
//        return -1;
        //哈希表存储下标,LinkedHashMap保证和存入顺序一致
        HashMap<Character, Integer> map = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,-1);
            }else{
                map.put(c,i);
            }
        }
        for (Integer value : map.values()) {
            if(value != -1){
                return value;
            }
        }
        return -1;




    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));
    }
}
