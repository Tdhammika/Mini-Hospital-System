package datastructures;

import model.Patient;

public class PatientBST {
    
    // BST Node Class
    private class Node {
        Patient patient;
        Node left, right;

        public Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public PatientBST() {
        this.root = null;
    }

    // 1. Insert Patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        }
        return root;
    }

    // 2. Search Patient using Patient ID
    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return (root != null) ? root.patient : null;
        }
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    // 3. In-order Traversal (Display in ascending order of Patient ID)
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }

    // 4. Delete Patient
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) return root;

        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient minVal = root.patient;
        while (root.left != null) {
            minVal = root.left.patient;
            root = root.left;
        }
        return minVal;
    }
}