package datastructures;

import model.TreatmentRecord;

public class TreatmentStack {

    private class Node {
        TreatmentRecord record;
        Node next;

        public Node(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        this.top = null;
    }

    // Empty handling
    public boolean isEmpty() {
        return top == null;
    }

    // 1. Push - Add a completed treatment record
    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record added to Stack.");
    }

    // 2. Pop - Remove the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment History Stack is Empty!");
            return null;
        }
        TreatmentRecord poppedRecord = top.record;
        top = top.next;
        return poppedRecord;
    }

    // 3. Display treatment records
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Treatment History Stack is Empty!");
            return;
        }
        System.out.println("--- Treatment History (LIFO Stack) ---");
        Node current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }
}