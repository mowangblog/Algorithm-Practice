# 魔王的Leetcode刷题笔记

## 前言

每天刷一道Leetcode算法题也有一段时间了，也看了一些大神写的一些刷题笔记，明白归纳总结的重要性。为了更好的总结吸收刷题时的心得体会，也为了能给其他人一些帮助，我打算把以后刷题时的思路和总结都整理成笔记放出来，我虽不是什么算法大神，但是如果看到这篇笔记的人能得到一点帮助那也是很棒的。（本文已Java作为示例）

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
