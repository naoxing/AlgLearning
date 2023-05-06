package com.xiaojiang.jichu;

/**
 * @Author xiaojiang
 * @Date 2023-04-28 10:24
 * @Description 206.反转链表
 **/
public class Test005 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        //遍历
        ListNode listNode1 = reverseList2(listNode);
        while (listNode1!=null){
            System.out.print(listNode1.val);
            listNode1 = listNode1.next;
        }
    }


    //递归
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;
    }



        //迭代
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null,next;
        ListNode currt = head;
        while (currt!=null){
            next = currt.next;
            currt.next = pre;
            pre = currt;
            currt = next;
        }
        return pre;
    }

}


 class ListNode { //链表
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
