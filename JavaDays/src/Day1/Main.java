package Day1;

public class Main {
    public static void main(String[] args) {
        HR.check("Same",10000,"Middle");
    }

    public static void print(String prof,String text){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~");
        stringBuilder.append(prof);
        stringBuilder.append(": ");
        stringBuilder.append(text);
        System.out.println(stringBuilder);
    }
}