
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    private void printList(ListNode l) {
        while(l != null) {
            System.out.print(l.val + " ");
            System.out.println();
            l = l.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        else if(l2 == null) {
            return l1;
        }

        ListNode temp = null;
        if(l1.val > l2.val) {
            temp = l2;
            l2 = l1;
            l1 = temp;
        }

        ListNode t1 = l1;
        ListNode t1_next = l1.next;
        ListNode t2 = l2;
        ListNode t2_next = t2.next;

       if(t1_next == null) {
            t1.next = t2;
            return l1;
        }
        

        while(t1!=null && t2!=null) {
            if(t2.val>=t1.val && t2.val<t1_next.val) {
                t2_next = t2.next;
                t1.next = t2;
                t2.next = t1_next;

                t1 = t2;
                t2 = t2_next;
            }
            else {
                if(t1_next.next != null) {
                    t1_next = t1_next.next;
                    t1 = t1.next;
                }
                else {
                    t1_next.next = t2;
                    return l1;
                }
            }
        }
        return l1;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        // l1.next = new ListNode(2);
        // l1.next.next = new ListNode(6);
        // l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        // l2.next = new ListNode(-1);
        // l2.next.next = new ListNode(0);

        Solution s = new Solution();
        s.mergeTwoLists(l1, l2);
        s.printList(l1);

    }
}