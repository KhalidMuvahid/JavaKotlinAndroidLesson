package Day8.inLesson.fragmentWorkScreenGenerics;

public class Main {
    public static void main(String[] args) {
        ScreenFragment fragment = new ScreenFragment(new ScreenPresenter());
        ScreenView view = new ScreenView();
        fragment.onResume(view);
    }
}