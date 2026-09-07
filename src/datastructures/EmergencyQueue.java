package datastructures;

import model.Patient;

public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Empty handling
    public boolean isEmpty() {
        return front == null;
    }

    // 1. Enqueue - Add a patient to the waiting queue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    // 2. Dequeue - Remove the next patient for treatment
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency Queue is Empty! No patients waiting.");
            return null;
        }
        Patient dequeuedPatient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedPatient;
    }

    // 3. Display all patients currently waiting
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency Queue is Empty!");
            return;
        }
        System.out.println("--- Current Emergency Waiting Queue (FIFO) ---");
        Node current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }
}