package architecture.mvptest.presenter;

import architecture.mvptest.view.TriviaView;

/**
 * Created by Tiago on 21/12/2015.
 */
public interface TriviaPresenter extends Presenter{
    void getTriviaText();
    void setView(TriviaView view);
}
