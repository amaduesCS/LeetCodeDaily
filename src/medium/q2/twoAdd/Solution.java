package medium.q2.twoAdd;


/*Unfinished*/
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode nsum = sum;
        int carry =0;
        while(l1 != null || l2 !=null){

            int v1 = l1 == null ? 0: l1.val;
            int v2 = l2 == null ? 0: l2.val;
            //nsum.val = (v1+v2+ carry) %10;
            carry = (v1+v2 + carry)/10;
            l1 = l1 == null ? null: l1.next;
            l2 = l2 == null ? null: l2.next;
            nsum = new ListNode((v1+v2+ carry) %10);
            nsum  = nsum.next;
         }
        if(carry !=0){
            nsum.next.val =1;
        }
        return sum;
    }
}