/*
Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
Solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list.
-CodeFights.com
*/

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
