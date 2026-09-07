package model;

public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatmentDetails;

    public TreatmentRecord(int patientId, String patientName, String doctorName, String treatmentDetails) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + patientName + 
               ", Doctor: " + doctorName + ", Treatment: " + treatmentDetails;
    }
}