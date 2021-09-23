package top.mowangblog.algorithm.easy.剑指offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * Algorithm-Daily-practice
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * @author : Xuan Li
 * @date : 2021-09-22 19:27
 **/
public class CQueue {
    LinkedList<Integer> listA,listB;
    public CQueue() {
      listA = new LinkedList<>();
      listB = new LinkedList<>();
    }

    public void appendTail(int value) {
        listA.add(value);
    }

    public int deleteHead() {
        if(!listB.isEmpty()){
            return listB.removeLast();
        }
        if(listA.isEmpty()){
            return -1;
        }
        while (!listA.isEmpty()){
            listB.add(listA.removeLast());
        }
        return listB.removeLast();
    }
}
