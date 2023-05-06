package com.xiaojiang.jichu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @Author xiaojiang
 * @Date 2023-05-04 23:08
 * @Description 141.环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 **/
public class Test011 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        n1.next = n3;
        System.out.println(hasCycle(n4));
    }


    //map
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (head.next!=null){
            if(map.containsKey(head)){
                return true;
            }
            map.put(head,null);
            head = head.next;
        }
        return false;
    }

    //set
    public static boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(!set.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }

    //快慢指正
    public static boolean hasCycle2(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick){
            if(quick==null || quick.next==null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        System.out.println("我已经修改了,你更新一下");
        return true;
    }



}


