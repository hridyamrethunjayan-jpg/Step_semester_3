package string.assignment_problems;

class TrafficSignal{
    static void findLongestStreak(String signalLog){
        int currentcount=1;
        int longestcount=1;
        char longestcolor=signalLog.charAt(0);
        for(int i=1;i<signalLog.length();i++){
            if(signalLog.charAt(i)==signalLog.charAt(i-1)){
                currentcount++;
            }else{
                currentcount=1;
            }
            if(currentcount>longestcount){
                longestcount=currentcount;
                longestcolor=signalLog.charAt(i);
            }
        }
        System.out.println("Longest Streak: "+longestcolor+" repeated "+longestcount+" times");
    }
    public static void main(String args[]){
        findLongestStreak("RRGGGYRR");
    }
}
