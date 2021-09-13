package top.mowangblog.algorithm.easy.day202109;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * Algorithm-Daily-practice
 * 移除链表元素
 *
 * @author : Xuan Li
 * @date : 2021-09-13 10:20
 **/
public class RemoveLinkElements {
//    public ListNode removeElements(ListNode head, int val) {
//        //递归
//        if(head == null){
//            return null;
//        }
//        head.next = removeElements(head.next,val);
//        return head.val == val?head.next:head;
//    }

    public ListNode removeElements(ListNode head, int val) {
        //迭代遍历
        if(head == null){
            return null;
        }
        ListNode first = new ListNode();
        first.next = head;
        ListNode newListNode = first;
        while (newListNode.next != null) {
            if (newListNode.next.val == val) {
                newListNode.next = newListNode.next.next;
            }else{
                newListNode = newListNode.next;
            }
        }
        return first.next;
    }
}
