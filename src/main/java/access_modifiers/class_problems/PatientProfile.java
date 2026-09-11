package access_modifiers.class_problems;

class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    public PatientProfile() {
        this(null, null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String id) {
        if (patientId == null)
            patientId = id;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        lockerPin = pin;
    }

    public static void main(String[] args) {
        PatientProfile p1 = new PatientProfile();
        p1.setPatientId("MT2026-0142");
        p1.setPatientId("HACKED-0000");
        System.out.println(p1.getPatientId());

        PatientProfile p2 = new PatientProfile("Arjun Iyer");
        System.out.println(p2.getPatientId());

        PatientProfile p3 = new PatientProfile("MT2026-0142", "Arjun Iyer");
        System.out.println(p3.getPatientId());
    }
}