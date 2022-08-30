class Solution {
    //used this to make it extansiable in terms of kth max element. 
    int maxLinkedListSize = 3;
    public int thirdMax(int[] nums) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(ll.size() < maxLinkedListSize)   insertElement(ll, nums[i]);
            else if(ll.size() == maxLinkedListSize && ll.peekLast() < nums[i]){
                insertElement(ll,nums[i]);
            }
            if(ll.size() > maxLinkedListSize) ll.pollLast();
        }
        return ll.size() == maxLinkedListSize ? ll.peekLast() : ll.peek();
    }
    
    //saving the elements in a way where linkedlist should be in assending order always;
    //for this we will check each element if it is bigger then the inserting element we will add that just after that node.
    public void insertElement(LinkedList<Integer> ll, int ele){
        if(ll.size() > 0 && ll.peekLast() == ele) return; //here we are just check if that elements is alrady there then just returning.
        if(ll.size() == 0 || ll.peekLast() > ele){
            ll.add(ele);
            return;
        }
        
        int temp = ll.pollLast();
        insertElement(ll,ele);
        ll.addLast(temp);
    }
}
