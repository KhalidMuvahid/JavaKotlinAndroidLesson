package Day2.task1;

public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = concatenation(str1,str2);
    }

    private static String concatenation(String str1, String str2) {
        String str = str1+" "+str2;
        System.out.println(str);
        return str;
    }
}
