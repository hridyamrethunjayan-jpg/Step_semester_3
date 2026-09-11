package access_modifiers.class_problems;

class AccessRule {
    static String classifyAccess(String fieldModifier,String accessorContext) {
        if(fieldModifier.equals("private")) {
            if(accessorContext.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("default")) {
            if(accessorContext.equals("SAME_CLASS")||accessorContext.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("protected")) {
            if(accessorContext.equals("SAME_CLASS")||accessorContext.equals("SAME_PACKAGE")||accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
                return "ALLOWED";
            else
                return "DENIED";
        }
        if(fieldModifier.equals("public"))
            return "ALLOWED";
        return "DENIED";
    }

    static String describeContext(String accessorContext) {
        String[] words=accessorContext.split("_");
        String result="";
        for(String word:words) {
            word=word.toLowerCase();
            word=Character.toUpperCase(word.charAt(0))+word.substring(1);
            result=result+word+" ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected","SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected","SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}