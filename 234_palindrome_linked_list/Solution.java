class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head == null) {
            return true;
        }
        if(head.next == null) {
            return true;
        }

        ListNode a = head;
        ListNode temp = head;
        ListNode b = head;
        ListNode c = b.next;

        while(c.next != null) {
            b = b.next;
            c = c.next;
        }

        while(b.next != a) {
            if(a.val != c.val) {
                return false;
            }
            if(temp != b) {
                while(temp.next != b) {
                    temp = temp.next;
                }
            }
            c = b;
            b = temp;
            a = a.next;
            temp = a;
        }
        return true;
    }

    public static void main(String args[]) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        // l.next.next.next = new ListNode(1);
        Solution s = new Solution();
        System.out.println(s.isPalindrome(l));

    }
}