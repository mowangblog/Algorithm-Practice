package top.mowangblog.algorithm.easy.剑指offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * Algorithm-Daily-practice
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * @author : Xuan Li
 * @date : 2021-09-19 22:33
 **/
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        //用栈
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }
        int size = linkedList.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = linkedList.removeLast();
        }
        return arr;
        //倒叙遍历
//        int[] arr = new int[10001];
//        int i = 10000;
//        while (head != null) {
//            arr[i--] = head.val;
//            head = head.next;
//        }
//        return Arrays.copyOfRange(arr,i+1,10001);
        //双指针反转数组
//        int[] arr = new int[10001];
//        int i = 0;
//        while (head != null) {
//            arr[i++] = head.val;
//            head = head.next;
//        }
//        int[] newArr = Arrays.copyOf(arr, i);
//        int p1 = 0;
//        int p2 = newArr.length-1;
//        while (p1 < p2){
//            int temp = newArr[p1];
//            newArr[p1] = newArr[p2];
//            newArr[p2] = temp;
//            p1++;
//            p2--;
//        }
//        return newArr;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        int[] arr = new ReversePrint().reversePrint(listNode1);
        for (int anInt : arr) {
            System.out.println(anInt);
        }

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

