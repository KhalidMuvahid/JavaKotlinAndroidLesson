package Day3.home;

public class Main {
    //overloading
    public static void main(String[] args) {
        div(44,22.9);
        div(44,22f);
        divWithNullCheck(44,0);
        divWithNullCheck(0,44);
        divWithNullCheck(44,44);


    }

    private static void divWithNullCheck(int i, int i1) {
        if (i ==0 || i1 == 0){
            System.out.println("undivided value");
        }else {
            System.out.println("value: "+(i/i1));
        }
    }

    static void div(int a,double b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }

    static void div(int a,float b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }

    static void div(double a,double b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }

    static void div(float a,float b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }

    static void div(long a,long b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }
    static void div(int a,int b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }
    static void div(byte a,byte b){
        System.out.println("you div "+a+" to "+b+" result is "+(a/b));
    }
}
