package com.observeai.llops;

public class LinkedListOperations {

    //method to sum two LinkedList and return sum in a LinkedList
    //Time complexity O(m+n), m is the size of list1, n is the size of list2
    public LinkedList sum(LinkedList list1, LinkedList list2) {
        LinkedList newHead = new LinkedList();
        if (list1 == null || list1.getHead() == null) {
            list1 = new LinkedList();
            list1.addAtBeginning(new Node(0));
        }
        if (list2 == null || list2.getHead() == null) {
            list2 = new LinkedList();
            list2.addAtBeginning(new Node(0));
        }

        Node head1 = list1.reverse();
        Node head2 = list2.reverse();
        int carry = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                carry += head1.val;
                head1 = head1.next;
            }
            if(head2 != null) {
                carry += head2.val;
                head2 = head2.next;
            }
            newHead.addAtBeginning(new Node(carry%10));
            carry /= 10;
        }
        if (carry != 0) {
            newHead.addAtBeginning(new Node(carry));
        }
        list1.reverse();
        list2.reverse();
        return newHead;
    }

    //Optimised method to sum two LinkedLists with their head pointers as parameter and return the head of resulted LinkedList
    //Time complexity O(m+n), m is the size of list1, n is the size of list2
    public Node optimizedSum(Node head1, Node head2) {
        if (head1 == null && head2 == null) return new Node(0);
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node rev1 = reverseUtil(head1);
        Node rev2 = reverseUtil(head2);
        Node newHead = null;
        int carry = 0;
        Node prev1 = null, curr1 = rev1, next1 = null;
        Node prev2 = null, curr2 = rev2, next2 = null;
        while(rev1 != null || rev2 != null) {
            if(rev1 != null) {
                carry += rev1.val;
                rev1 = rev1.next;
                next1 = curr1.next;
                curr1.next = prev1;
                prev1 = curr1;
                curr1 = next1;
            }
            if(rev2 != null) {
                carry += rev2.val;
                rev2 = rev2.next;
                next2 = curr2.next;
                curr2.next = prev2;
                prev2 = curr2;
                curr2 = next2;
            }
            Node node = new Node(carry%10);
            node.next = newHead;
            newHead = node;
            carry /= 10;
        }
        if (carry != 0) {
            Node remCarry = new Node(carry);
            remCarry.next = newHead;
            newHead = remCarry;
        }

        return newHead;

    }

    //method to multiply two LinkedLists and return result in LinkedList
    //Time complexity O(m*n) m is the size of list1, n is the size of list2
    public LinkedList multiply(LinkedList list1, LinkedList list2){
        LinkedList newHead = new LinkedList();
        if (list1 == null || list2 == null || list1.getHead() == null || list2.getHead() == null) {
            newHead.addAtBeginning(new Node(0));
            return newHead;
        }

        Node head1 = list1.reverse();
        Node head2 = list2.reverse();
        int carry = 0;
        int numOfZeroesToBeAppended = 0;
        while (head2 != null) {
            int val = head2.val;
            Node temp = head1;
            LinkedList tempList = new LinkedList();
            while(temp != null) {
                int newVal = (val * temp.val) + carry;
                tempList.addAtBeginning(new Node(newVal%10));
                carry = newVal / 10;
                temp = temp.next;
            }
            if (carry != 0) {
                tempList.addAtBeginning(new Node(carry));
                carry = 0;
            }
            for(int i=0; i<numOfZeroesToBeAppended; i++) {
                tempList.addNodeAtTheEnd(new Node(0));
            }
            numOfZeroesToBeAppended++;
            newHead = sum(newHead, tempList);
            head2 = head2.next;
        }
        list1.reverse();
        list2.reverse();
        return newHead;
    }

    public LinkedList subtract(LinkedList list1, LinkedList list2){
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        int size1 = list1.size();
        int size2 = list2.size();
        if (size1 != size2) {
            int diff = Math.abs(size1 - size2);
            if (size1 > size2) {
                addZeroes(diff, list2);
            } else {
                addZeroes(diff, list1);
            }
        }

        return null;
    }


    public LinkedList divide(LinkedList list1, LinkedList list2){
        return null;
    }

    private Node reverseUtil(Node head) {
        if (head == null) return null;
        Node curr = head, prev = null, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void addZeroes(int numOfZeroes, LinkedList linkedList) {
        for (int i=0; i<numOfZeroes; i++) {
            linkedList.addNodeAtTheEnd(new Node(0));
        }
    }
}
