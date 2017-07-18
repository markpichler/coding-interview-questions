/*
Given a singly linked list of integers l, determine whether or not it's a palindrome.
Solve this task in O(n) time using O(1) additional space, where n is the number of elements in l.
*/

boolean isListPalindrome(ListNode<Integer> l) {
    //Check for empty list.
    if (l == null || l.next == null)
        return true;
    
    //Pointers
    ListNode<Integer> pSlow = l, pSlowPrev = l, pFast = l, h1 = l, h2, temp = null, rev = null; 
   
    //Step 1: Split list into two halves.
    while (pFast != null  && pFast.next != null) {
        //Advance fast pointer two nodes.
        pFast = pFast.next.next;
        
        //Save previous slow pointer.
        pSlowPrev = pSlow;
        
        //Advance slow pointer one node.
        pSlow = pSlow.next;
        
        temp = pSlowPrev;
        pSlowPrev.next = rev;
        rev = temp;
    }

    //Even number of nodes - fast pointer will land on null.
    if (pFast == null) {
        //Separate into two separate lists.
        h2 = pSlow;
        h1 = pSlowPrev;
    //Odd number of nodes - fast pointer will land right before null.
    } else {
        //Discard center node as it's irrelevant in a palindrome.
        h2 = pSlow.next;
        h1 = pSlowPrev;
    }
    
    while (h1 != null && h2 != null) {
    
        if ((h1.value).compareTo(h2.value) != 0)
            return false;

        h1 = h1.next;
        h2 = h2.next;
        
    }

    return true;

}
