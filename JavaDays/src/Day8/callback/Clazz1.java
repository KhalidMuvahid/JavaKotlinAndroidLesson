package Day8.callback;

public class Clazz1{

    SomeCallBack callBack;

    public Clazz1(SomeCallBack callBack){
        this.callBack = callBack;
        callBack.someMeth("From Clazz1");
    }
}
