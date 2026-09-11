package access_modifiers.class_problems;

class DischargeSummary {
    private final String patientId;
    private final String[] medicationCodes;
    static String ledgerStatus;
    static {
        ledgerStatus="READY";
    }
    public DischargeSummary(String patientId,String[] medicationCodes) {
        for(String code:medicationCodes) {
            if(code==null||code.length()!=5||code.charAt(0)!='M'||code.charAt(1)!='E'||code.charAt(2)!='D'||code.charAt(3)!='-'||code.charAt(4)<'A'||code.charAt(4)>'Z')
                throw new IllegalArgumentException("Invalid medication code");
        }

        this.patientId=patientId;
        this.medicationCodes=medicationCodes.clone();
    }
    String[] getMedicationCodes() {
        return medicationCodes.clone();
    }
    DischargeSummary withCorrectedMedication(int index,String newCode) {
        if(newCode==null||newCode.length()!=5||newCode.charAt(0)!='M'||newCode.charAt(1)!='E'||newCode.charAt(2)!='D'||newCode.charAt(3)!='-'||newCode.charAt(4)<'A'||newCode.charAt(4)>'Z')
            throw new IllegalArgumentException("Invalid medication code");

        String[] copy=medicationCodes.clone();
        copy[index]=newCode;

        return new DischargeSummary(patientId,copy);
    }

    static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed=0;
        int nullSkipped=0;
        int critical=0;
        int routine=0;

        for(DischargeSummary summary:summaries) {
            if(summary==null) {
                nullSkipped++;
            }
            else {
                processed++;

                if(summary instanceof CriticalCareDischargeSummary)
                    critical++;
                else
                    routine++;
            }
        }
        return processed+" processed | "+nullSkipped+" null skipped | "+critical+" critical-care | "+routine+" routine";
    }
    public static void main(String[] args) {
        try {
            DischargeSummary d1=new DischargeSummary("MT2026-0142",new String[]{"MED-A","bad"});
        }
        catch(IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
        String[] codes={"MED-A","MED-B"};
        DischargeSummary d2=new DischargeSummary("MT2026-0142",codes);
        codes[0]="TAMPERED";
        System.out.println(d2.getMedicationCodes()[0]);
        DischargeSummary d3=new CriticalCareDischargeSummary("MT2026-0143",new String[]{"MED-C"},3);
        DischargeSummary[] summaries={d3,null,d2};
        System.out.println(processNightlyBatch(summaries));
    }
}
class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;
    public CriticalCareDischargeSummary(String patientId,String[] medicationCodes,int icuDays) {
        super(patientId,medicationCodes);
        this.icuDays=icuDays;
    }
}