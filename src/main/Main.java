package main;

import datastructures.*;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Data Structures Initialization
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        VisitLinkedList visitList = new VisitLinkedList();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Mini Hospital Emergency Management System ===");
            System.out.println("1. Patient Records Management (BST)");
            System.out.println("2. Emergency Queue Management (Queue)");
            System.out.println("3. Treatment History Management (Stack)");
            System.out.println("4. Patient Visit History Management (Linked List)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Patient Records (BST) ---");
                    System.out.println("1. Insert Patient");
                    System.out.println("2. Search Patient");
                    System.out.println("3. Delete Patient");
                    System.out.println("4. Display Patients (In-order)");
                    System.out.print("Option: ");
                    int bstOpt = scanner.nextInt(); scanner.nextLine();
                    if (bstOpt == 1) {
                        System.out.print("Enter ID: "); int id = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Name: "); String name = scanner.nextLine();
                        System.out.print("Enter Age: "); int age = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Contact: "); String contact = scanner.nextLine();
                        System.out.print("Enter Condition: "); String condition = scanner.nextLine();
                        bst.insert(new Patient(id, name, age, contact, condition));
                    } else if (bstOpt == 2) {
                        System.out.print("Enter Patient ID to Search: "); int id = scanner.nextInt();
                        Patient p = bst.search(id);
                        System.out.println((p != null) ? "Found: " + p : "Patient Not Found!");
                    } else if (bstOpt == 3) {
                        System.out.print("Enter Patient ID to Delete: "); int id = scanner.nextInt();
                        bst.delete(id);
                        System.out.println("Deletion process completed.");
                    } else if (bstOpt == 4) {
                        bst.inOrder();
                    }
                    break;

                case 2:
                    System.out.println("\n--- Emergency Queue ---");
                    System.out.println("1. Enqueue Patient");
                    System.out.println("2. Dequeue Patient");
                    System.out.println("3. Display Waiting Queue");
                    System.out.print("Option: ");
                    int qOpt = scanner.nextInt(); scanner.nextLine();
                    if (qOpt == 1) {
                        System.out.print("Enter ID: "); int id = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Name: "); String name = scanner.nextLine();
                        System.out.print("Enter Age: "); int age = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Contact: "); String contact = scanner.nextLine();
                        System.out.print("Enter Condition: "); String condition = scanner.nextLine();
                        queue.enqueue(new Patient(id, name, age, contact, condition));
                    } else if (qOpt == 2) {
                        Patient p = queue.dequeue();
                        if (p != null) System.out.println("Dequeued for treatment: " + p.getName());
                    } else if (qOpt == 3) {
                        queue.displayQueue();
                    }
                    break;

                case 3:
                    System.out.println("\n--- Treatment History (Stack) ---");
                    System.out.println("1. Push Treatment Record");
                    System.out.println("2. Pop Treatment Record");
                    System.out.println("3. Display Treatment History");
                    System.out.print("Option: ");
                    int sOpt = scanner.nextInt(); scanner.nextLine();
                    if (sOpt == 1) {
                        System.out.print("Enter Patient ID: "); int id = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Patient Name: "); String name = scanner.nextLine();
                        System.out.print("Enter Doctor Name: "); String doc = scanner.nextLine();
                        System.out.print("Enter Details: "); String details = scanner.nextLine();
                        stack.push(new TreatmentRecord(id, name, doc, details));
                    } else if (sOpt == 2) {
                        TreatmentRecord tr = stack.pop();
                        if (tr != null) System.out.println("Popped Record: " + tr);
                    } else if (sOpt == 3) {
                        stack.displayStack();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Patient Visit History (Linked List) ---");
                    System.out.println("1. Add Visit");
                    System.out.println("2. Remove Visit");
                    System.out.println("3. Search Visit");
                    System.out.println("4. Display Visit History");
                    System.out.print("Option: ");
                    int lOpt = scanner.nextInt(); scanner.nextLine();
                    if (lOpt == 1) {
                        System.out.print("Enter Visit ID: "); int vId = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Enter Date: "); String date = scanner.nextLine();
                        System.out.print("Enter Doctor Name: "); String doc = scanner.nextLine();
                        System.out.print("Enter Diagnosis: "); String diag = scanner.nextLine();
                        System.out.print("Enter Treatment: "); String trt = scanner.nextLine();
                        visitList.addVisit(new Visit(vId, date, doc, diag, trt));
                    } else if (lOpt == 2) {
                        System.out.print("Enter Visit ID to remove: "); int vId = scanner.nextInt();
                        visitList.removeVisit(vId);
                    } else if (lOpt == 3) {
                        System.out.print("Enter Visit ID to search: "); int vId = scanner.nextInt();
                        Visit v = visitList.searchVisit(vId);
                        System.out.println((v != null) ? "Found: " + v : "Visit Not Found!");
                    } else if (lOpt == 4) {
                        visitList.displayHistory();
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
    }
}