package Day8.callback;

public class Solution {
    public static void main(String[] args) {
        SomeCallBack callback =new CallbackRealization();

        Clazz1 c = new Clazz1(callback);
        Clazz2 c2 = new Clazz2(callback);


    }
}
