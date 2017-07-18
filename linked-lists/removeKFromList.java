// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> lIter = l, lIterPrev = null;
    
    //Case of empty list
    if (l == null) 
        return null;
    
    
   
    while (lIter != null) {
        if (lIter.value == k) {
            //Case of first element
            if (lIterPrev == null) {
                l = l.next;
                lIter = lIter.next;
                continue;
            //Case of last element
            } else if (lIter.next == null) {
                lIterPrev.next = null;
                return l;
            } else {
                lIterPrev.next = lIter.next;
                lIter = lIter.next;
                continue;
            }
        }
        lIterPrev = lIter;
        lIter = lIter.next;
        
    }
    
    return l;
}
