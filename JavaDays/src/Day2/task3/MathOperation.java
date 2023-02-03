package Day2.task3;

public class MathOperation {
    public static void main(String[] args) {
        sum(22,44);
        minus(22,44);
        div(22,44);
        mul(22,44);
    }

    static void sum(int a,int b){
        System.out.println(a+b);
    }

    static void minus(int a,int b){
        System.out.println(a-b);

    }

    static void div(int a,int b){
        System.out.println(a/b);

    }

    static void mul(int a,int b){
        System.out.println(a*b);
    }
}
