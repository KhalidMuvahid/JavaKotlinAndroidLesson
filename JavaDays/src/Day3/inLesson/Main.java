package Day3.inLesson;

public class Main {
    //Float & Double
    public static void main(String[] args) {
        div(44,22.9);
        div(44,22f);
    }

    static void div(int a,double b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }

    static void div(int a,float b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }
}