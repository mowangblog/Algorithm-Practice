# 魔王的Leetcode刷题笔记

## 前言

每天刷几道Leetcode算法题也有一段时间了，也看了一些大神写的一些刷题笔记，明白归纳总结的重要性。为了更好的总结吸收刷题时的心得体会，也为了能给其他人一些帮助，我打算把以后刷题时的思路和总结整理成笔记放出来，持续更新我虽不是什么算法大神，但是如果看到这篇笔记的人能得到一点帮助那也是很棒的。（本文已Java语言作为示例）

**最后更新时间：**

## 链表

### [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)

#### LeetCode原题：

> 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
>
> 返回同样按升序排列的结果链表。
>
> 示例 1：
>
> 输入：head = [1,1,2]
> 输出：[1,2]
> 示例 2：
>
>
> 输入：head = [1,1,2,3,3]
> 输出：[1,2,3]
>
>
> 提示：
>
> 链表中节点数目在范围 [0, 300] 内
> -100 <= Node.val <= 100
> 题目数据保证链表已经按升序排列

#### 题解：

##### **思路与算法**

由于题目的条件链表是排好序的，因此**重复的元素在链表中出现的位置是连续的**，因此我们只需要对链表进行一次遍历，就可以删除掉重复的元素。

##### **代码**

```java
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
```

##### **提交截图**

![image-20210912192742158](https://res.mowangblog.top/img/2021/09/image-20210912192742158.png)

### [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

#### LeetCode原题：

> 给定一个链表，判断链表中是否有环。
>
> 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
>
> 如果链表中存在环，则返回 true 。 否则，返回 false 。
>
> 进阶：
>
> 你能用 O(1)（即，常量）内存解决此问题吗？
>
> 示例 1：
>
> 输入：head = [3,2,0,-4], pos = 1
> 输出：true
> 解释：链表中有一个环，其尾部连接到第二个节点。
> 示例 2：
>
> 输入：head = [1,2], pos = 0
> 输出：true
> 解释：链表中有一个环，其尾部连接到第一个节点。
> 示例 3：
>
> 输入：head = [1], pos = -1
> 输出：false
> 解释：链表中没有环。
>
> 提示：
>
> 链表中节点的数目范围是 [0, 104]
> -105 <= Node.val <= 105
> pos 为 -1 或者链表中的一个 有效索引 。
>
> **相关标签：哈希表，链表，双指针**

#### 题解：

##### **思路与算法**

###### 解法1：哈希表

最简单的方法是使用哈希表来存储所有已经访问过的节点，每次我们到达一个节点，判断该节点此前是否被访问过，如果该节点已经存在于哈希表中，则说明该链表是环形链表，否则就将该节点加入哈希表。

###### 解法2：快慢指针（floyd判环算法）

定义一快一满两个指针，设置慢指针每次只移动一步，而快指针每次移动两步。初始时，慢指针在位置 head，而快指针在位置 head.next。这样一来，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，该链表不为环形链表。

![来源于网络](https://res.mowangblog.top/img/2021/09/5e2c95b3f62e2fc23667d769505913ad.png)

##### **代码1**

```
public boolean hasCycle(ListNode head) {
        //哈希表
        if (head == null || head.next == null) {
            return false;
        }
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head.next != null){
            //添加失败说明已经哈希表中已经有这个节点，链表进入了环
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        //遍历完都没有重复说明不是环形链表
        return false;
}
```

##### **代码2**

```
public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
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
```

##### **提交截图**

![image-20210918113144438](https://res.mowangblog.top/img/2021/09/image-20210918113144438.png)

## 双指针

### [125. 验证回文串](https://leetcode-cn.com/problems/valid-palindrome/)

#### LeetCode原题：

> 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
>
> 说明：本题中，我们将空字符串定义为有效的回文串。
>
> 示例 1:
>
> 输入: "A man, a plan, a canal: Panama"
> 输出: true
> 解释："amanaplanacanalpanama" 是回文串
> 示例 2:
>
> 输入: "race a car"
> 输出: false
> 解释："raceacar" 不是回文串
>
>
> 提示：
>
> 1 <= s.length <= 2 * 105
> 字符串 s 由 ASCII 字符组成

#### 题解：

##### **思路与算法**

###### 解法1：翻转判断

最简单的方法是对字符串进行一次遍历，并`Character.isLetterOrDigit()`方法将其中的字母和数字字符进行保留，放在`StringBuilder`中。这样我们只需要把结果翻转判断是否是一个的回文串即可。

###### 解法2：双指针

左右指针分别总两端找到找到符合数字或字母的字符进行比较。
相等继续找下一个，不相等返回false;

另外Java可以通过`Character.isLetterOrDigit()`方法可以判断字符是否是字母或者数字，`Character.toLowerCase()`把字母转化为小写来比较。

##### 代码1

```java
public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        //翻转判断
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                //符合要求的字符用StringBuilder存起来
                stringBuilder.append(s.charAt(i));
            }
        }
        String s1 = stringBuilder.toString().toLowerCase();
    	//把字符串翻转并转化为小写后比较，相同则是回文串
        String s2 = stringBuilder.reverse().toString().toLowerCase();
        return s1.equals(s2);
    }
```

##### **代码2**

```java
 public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        //双指针
        int p1 = 0;
        int p2 = s.length() - 1;
        while(p1 < p2){
            if(!Character.isLetterOrDigit(s.charAt(p1))){
                //不符合的字符直接跳过
                p1++;
            }else if(!Character.isLetterOrDigit(s.charAt(p2))){
                //不符合的字符直接跳过
                p2--;
            }else if(Character.toLowerCase(s.charAt(p1)) == Character.toLowerCase(s.charAt(p2))){
                //相等则进入下一位
                p1++;
                p2--;
            }else{
                //不相等说明不是回文串直接返回false
                return false;
            }
        }
        return true;
    }
```

##### **提交截图**

![image-20210917152326403](https://res.mowangblog.top/img/2021/09/image-20210917152326403.png)
