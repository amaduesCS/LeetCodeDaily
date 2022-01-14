package medium.q148.sortList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public static ListNode sortList(ListNode head) {

        partition(head,null);

        return head;
    }

    public static void partition(ListNode head, ListNode end){
        if(head==null || end == null){
            return;
        }
        int pivot = head.val;
        ListNode left = head;
        ListNode right = head;
        ListNode lastSwap = head;
        while(right!=end){
            while(left !=end && left.val <= pivot){
                left = left.next;
            }
            right = left;
            while(right !=end && right.val >= pivot){
                right = right.next;
            }
            lastSwap = left;
            if(right!=null){
                swap(left,right);
            }
        }
        swap(head,lastSwap);
        partition(head, lastSwap);
        partition(lastSwap,end);
    }

    public static void swap (ListNode node1, ListNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        sortList(head);
        System.out.println(head.val);
    }
}