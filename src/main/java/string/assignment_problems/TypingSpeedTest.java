package string.assignment_problems;

class TypingSpeedTest{
    static void checkTypingAccuracy(String original, String typed){
        int matched=0;
        int firstmismatch=-1;
        for(int i=0;i<original.length();i++){
            if(original.charAt(i)==typed.charAt(i)){
                matched++;
            }else if(firstmismatch==-1){
                firstmismatch=i;
            }
        }
        double accuracy=((double)matched/original.length())*100;
        System.out.println("Matched: "+matched+"/"+original.length()+" | Accuracy: "+accuracy);

        if(firstmismatch==-1){
            System.out.println(" | No Mismatches");
        }else{
            System.out.println(" | First mismatch at position "+(firstmismatch+1)+"("+original.charAt(firstmismatch)+" vs "+typed.charAt(firstmismatch)+")");
        }
    }
    public static void main(String args[]){
        checkTypingAccuracy("hello world","hello worlt");
    }
}

