package Day8.inLesson.fragmentWorkScreenGenerics;

public class ScreenPresenter extends Presenter<ScreenView>{

    @Override
    public void updateUI(ScreenView view) {
        super.updateUI(view);
        super.view.goToScreen();
    }

    @Override
    public void stopUI() {

    }
}
