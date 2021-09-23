package top.mowangblog.algorithm.easy.day202109;

import java.util.HashSet;

/**
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * Algorithm-Daily-practice
 * 是否是环形链表
 *
 * @author : Xuan Li
 * @date : 2021-09-13 21:13
 **/
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
//
//        //哈希表
//        if (head == null || head.next == null) {
//            return false;
//        }
//        HashSet<ListNode> listNodes = new HashSet<>();
//        while (head.next != null){
//            //添加失败说明已经哈希表中已经有这个节点，链表进入了环
//            if (!listNodes.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        //遍历完都没有重复说明不是环形链表
//        return false;

        //快慢指针
        ListNode low = head;
        ListNode fast = head.next;
        //如果快指针追上了慢指针，是环形链表，退出循环
        while (low != fast){
            //出现null说明遍历完了链表，不是环形链表
            if(fast == null || fast.next == null){
                return false;
            }
            //慢指针每次前进一步
            low = low.next;
            //快指针每次前进两步
            fast = fast.next.next;
        }
        //快指针追上了慢指针是环形链表，返回true
        return true;
    }
}
