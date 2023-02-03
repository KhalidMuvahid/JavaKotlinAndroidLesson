package Day8.inLesson.fragmentWorkScreenGenerics;

public abstract class Fragment<V extends View,T extends Presenter<V>> {
    private T presenter;

    public Fragment(T presenter){
        this.presenter = presenter;
    }
    public void onResume(V view) {
        presenter.updateUI(view);
    }

    public void onPause() {
        presenter.stopUI();
    }
}
