/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        //finding middle element of the list.
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse the secound half elemets
        ListNode partSecound = reverseStartingKNodes(slow.next);
        ListNode partFirst = head;
        
        //checking every element from both part is the are equal or not if not then return false because in that case this list is not Palindrome.
        while(partFirst != null && partSecound != null){
            if(partFirst.val != partSecound.val) return false;
            partFirst = partFirst.next;
            partSecound = partSecound.next;
        }
        
        return true;
            
    }
    
    public ListNode reverseStartingKNodes(ListNode head){
        ListNode currNode = head;
        ListNode preNode = null;
        while(currNode != null){
            ListNode afterNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = afterNode;
        }
        return preNode;
    }
}
