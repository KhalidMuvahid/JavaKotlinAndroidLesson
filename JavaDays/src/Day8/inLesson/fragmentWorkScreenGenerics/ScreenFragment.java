package Day8.inLesson.fragmentWorkScreenGenerics;

public class ScreenFragment extends Fragment<ScreenView,ScreenPresenter>{
    public ScreenFragment(ScreenPresenter presenter) {
        super(presenter);
    }
}
