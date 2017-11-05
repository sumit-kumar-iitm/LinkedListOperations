package com.observeai.llops;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    //method to add node at the beginning of the LinkedList
    public void addAtBeginning(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //method to add node at the end of the LinkedList
    public void addNodeAtTheEnd(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    //method to reverse Linkedlist
    public Node reverse() {
        if (head == null) {
            return null;
        }
        Node prev = null, next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
        return head;
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        if (head == null) return 0;
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public void print() {
        while(head != null) {
            System.out.print(head.val+"");
            head = head.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        while(head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return sb.toString();
    }

}
