package Day8.inLesson.fragmentWorkScreenGenerics;

public abstract class Presenter<V extends View> {

    protected  V view;
    public  void updateUI(V view){
        this.view = view;
    };

    public void stopUI(){
        this.view = null;
    };

}
