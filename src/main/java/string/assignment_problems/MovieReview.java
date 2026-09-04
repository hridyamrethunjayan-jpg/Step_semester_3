package string.assignment_problems;

class MovieReview{
    static void classifyWordLengths(String review){
        int shortcount=0;
        int mediumcount=0;
        int longcount=0;

        String[] words=review.split(" ");
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int length=word.length();
            if(length>=1 && length<=4){
                shortcount++;
            }else if(length>=5 && length<=8){
                mediumcount++;
            }else{
                longcount++;
            }
        }
        System.out.println("Short: "+shortcount+" | Medium: "+mediumcount+" | Long: "+longcount);
    }
    public static void main(String args[]){
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
