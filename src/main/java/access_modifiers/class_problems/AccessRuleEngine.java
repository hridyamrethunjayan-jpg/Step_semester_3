class AccessRuleEngine {
    static String classifyAccess(String fieldModifier,String accessorContext) {
        if(fieldModifier.equals("private")) {
            if(accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("default")) {
            if(accessorContext.equals("SAME_CLASS")||(accessorContext.equals("SAME_PACKAGE")))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("protected")) {
            if(accessorContext.equals("SAME_CLASS")||(accessorContext.equals("SAME_PACKAGE")))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("public")) {
            return "ALLOWED";
        }
        return "DENIED";
    }
    static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;
        for(String[] attempt : attempts) {
            if(classifyAccess(attempt[0],attempt[1]).equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
    public static void main(String[] args) {
        String[][] attempts = {
                {"protected","SAME_PACKAGE"},
                {"protected","DIFFERENT_PACKAGE"},
                {"public","DIFFERENT_PACKAGE"}
        };
        System.out.println(classifyAccess("private","SAME_CLASS"));
        System.out.println(classifyAccess("default","DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(attempts));
        try{
            PatientRecord p1 = new PatientRecord("MT9","W3",98.2,"MediTrack Central");
        }catch(IllegalArgumentException e) {
            System.out.println("Construction rejected");
        }
        PatientRecord p2 = new PatientRecord("MT94","W3",98.2,"MediTrack Central");    }
}
class PatientRecord {
    String patientId;
    String wardCode;
    double vitalsScore;
    String facilityName;
    PatientRecord(String patientId,String wardCode,double vitalsScore,String facilityName) throws IllegalArgumentException{
        String trimmed = patientId.trim();
        if(trimmed.length() < 4)
            throw new IllegalArgumentException("Invalid patient ID");
        this.patientId = trimmed;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }
}