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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) {
            return null;
        }
        ListNode a = head;
        ListNode temp = a.next;
        ListNode b = a;
        for(int i=0; i<n; i++) {
            b = b.next;
        }
        
        if(b == null) {
            return head.next;
        }

        while(b.next != null)  {
            a = a.next;
            temp = temp.next;
            b = b.next;
        }
        a.next = temp.next;
        temp.next = null;
        return head;
    }
    public static void main(String args[]) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);

        Solution s = new Solution();
        s.printList(s.removeNthFromEnd(l,1));
        
    }
}