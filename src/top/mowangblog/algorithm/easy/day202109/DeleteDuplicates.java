package top.mowangblog.algorithm.easy.day202109;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 示例 1：
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 *
 * Algorithm-Daily-practice
 * deleteDuplicates
 *
 * @author : Xuan Li
 * @date : 2021-09-12 18:33
 **/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //因为进去操作后head的指向会改变吗,因此先把原head地址存起来
        ListNode listNode = head;
        //如果链表不为空并且链表的下一个不为空就进入去重操作，否则直接返回
        while (head != null && head.next != null) {
            //拿到链表的下一个节点
            ListNode next = head.next;
            //由题目可知这是有序链表，因此我们只需要直接跟下一个节点比较是否重复即可
            if (head.val == next.val) {
                //如果重复了就去除这个节点
                head.next = next.next;
            }else{
                //没有重复则指向下一个节点，循环往复
                head = next;
            }
        }
        //返回原头节点
        return listNode;
    }
}
