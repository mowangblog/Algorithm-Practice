package top.mowangblog.algorithm.easy.剑指offer;

/**
 * Algorithm-Daily-practice
 * 剑指 Offer 05. 替换空格
 *
 * @author : Xuan Li
 * @date : 2021-09-18 17:50
 **/
public class ReplaceSpace {
    public String replaceSpace(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();

//        return s.replaceAll(" ","%20");
    }
}
