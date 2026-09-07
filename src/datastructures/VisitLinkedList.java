package datastructures;

import model.Visit;

public class VisitLinkedList {

    private class Node {
        Visit visit;
        Node next;

        public Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    public VisitLinkedList() {
        this.head = null;
    }

    // 1. Add a new visit to patient's history
    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit record added to history.");
    }

    // 2. Remove a visit by Visit ID
    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return false;
        }

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit ID " + visitId + " removed.");
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Visit ID " + visitId + " removed.");
            return true;
        }

        System.out.println("Visit ID " + visitId + " not found.");
        return false;
    }

    // 3. Search for a visit by Visit ID
    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    // 4. Display patient's visit history
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        System.out.println("--- Patient Visit History (Singly Linked List) ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }
}