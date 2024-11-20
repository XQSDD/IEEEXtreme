package org.example.utils.linkList;

/**
 * @author pc
 * @description 删除排序链表中的重复元素
 * @create 2023/10/27 20:59
 */
public class DeleteDuplicates {
    public class ListNode{
        int val;
        ListNode next;        //链表指向的下一个值的指针
        ListNode(int x){val = x;}   //这个方式赋值
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            // 全部删除完再移动到下一个元素
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }
}
