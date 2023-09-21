// reverse a linked list

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        } else{
            current.next = list2;
        }
        return dummy.next;
    }
}




//delete a single node in the linked list
if (nodeToDelete == null || nodeToDelete.next == null) {
        // You cannot delete the last node or a null node.
        return;
    }
    
    // Copy the value of the next node into the current node
    nodeToDelete.val = nodeToDelete.next.val;
    
    // Update the current node's next pointer to skip the next node
    nodeToDelete.next = nodeToDelete.next.next;



//remove duplicates from the sorted list
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        while(current != null){
            boolean isDuplicate = false;
            while(current.next != null && current.val == current.next.val){
                current = current.next;
                isDuplicate = true;
            }
            if(isDuplicate){
                prev.next = current.next;
            } else{
                prev = prev.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}



// flatten the linked list
class GfG {
    Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        result.next = null;
        return result;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }
}


//zig zag
class Solution {
    public static Node zigZag(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(0); // Create a dummy node to simplify list manipulation
        dummy.next = head;

        Node left = dummy;
        Node mid = head;
        Node right = head.next;
        boolean isLess = true; // Indicates whether the next swap should be < or >

        while (right != null) {
            if ((isLess && mid.data > right.data) || (!isLess && mid.data < right.data)) {
                int temp = mid.data;
                mid.data = right.data;
                right.data = temp;
            }

            left = left.next;
            mid = mid.next;
            right = right.next;
            isLess = !isLess; // Toggle isLess for the next iteration
        }
        return dummy.next;
    }
}

// reverse the doubly linked list

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class ReverseDoublyLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list recursively
        ListNode newHead = reverse(head.next);

        // Swap the next and prev pointers for the current node
        head.next = head.prev;
        head.prev = newHead;

        return head; // New head of the reversed list
    }
}


//Delete nodes having greater value on right for one position
class Solution
{
    Node compute(Node head)
    {
        // your code here
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node current = dummy.next;
        Node next = dummy.next.next;
        while(next != null){
            if(current.data < next.data){
                prev.next = next;
                current = next;
                next = next.next;
            } else{
                prev = prev.next;
                next = next.next;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
  
// delete nodes which have higher values on the right side
class Solution
{
    Node compute(Node head)
    {
        // your code here
        Node p=head;
        Node q=head;
        Node s=head;
        while(p.next != null){
            int c=0;
            q=p.next;
            while(q!=null){
                if( q.data > p.data){
                    if(p == head){
                        head = head.next;
                        p=head;
                        c++;
                        break;
                    }
                    else{
                        s.next=p.next;
                        p=s;
                        break;
                    }
                }
                q=q.next;
            }
            if(c ==0){
                s=p;
                p=p.next;
            }
            
        }
        return head;
    }
}

// odd and even separation 
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
    public ListNode oddEvenList(ListNode head) {
        ListNode even = new ListNode(-1);
        ListNode Estart = even;
        ListNode odd =  new ListNode(-1);
        ListNode Ostart = odd;
        boolean isEven = true;
        while(head != null){
            if(isEven){
                even.next = head;
                even = even.next;
            } else{
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            isEven = !isEven;
        }
        even.next = Ostart.next;
        odd.next = null;
        return Estart.next;
    }
}
// Code for the copy the linked list
class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // your code here
        // Create a mapping of original nodes to copied nodes using a HashMap
        Map<Node, Node> nodeMap = new HashMap<>();

        // First pass: Create copies of nodes without random pointers and store them in the HashMap
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.data));
            current = current.next;
        }

        // Second pass: Connect next and random pointers of copied nodes
        current = head;
        while (current != null) {
            Node copiedNode = nodeMap.get(current);
            copiedNode.next = nodeMap.get(current.next);
            copiedNode.arb = nodeMap.get(current.arb);
            current = current.next;
        }

        // Return the head of the copied list
        return nodeMap.get(head);
    }
}
