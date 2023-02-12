package Day8.callback;

public class Clazz2{
    SomeCallBack callBack;

    public Clazz2(SomeCallBack callBack){
        this.callBack = callBack;
        callBack.someMeth("From Clazz2");
    }
}
