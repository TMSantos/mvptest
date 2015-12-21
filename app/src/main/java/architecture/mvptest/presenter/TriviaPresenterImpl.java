package architecture.mvptest.presenter;

import architecture.mvptest.triviacallback.TriviaCallback;
import architecture.mvptest.model.TriviaEntity;
import architecture.mvptest.model.TriviaModel;
import architecture.mvptest.model.TriviaModelImpl;
import architecture.mvptest.view.TriviaView;

/**
 * Created by Tiago on 21/12/2015.
 */
public class TriviaPresenterImpl implements TriviaPresenter {

    TriviaView view;
    TriviaModel model;

    public TriviaPresenterImpl(TriviaView view){
        this(view,new TriviaModelImpl());
    }

    TriviaPresenterImpl(TriviaView view, TriviaModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getTriviaText() {
        model.getTriviaText(new TriviaCallback<TriviaEntity>() {
            @Override
            public void success(TriviaEntity triviaEntity) {
                view.setTriviaText(triviaEntity.getTriviaText());
            }

            @Override
            public void serverFailure(String error) {
                view.onServerFailure(error);
            }

            @Override
            public void networkFailure(String error) {
                view.onNetworkFailure(error);
            }
        });
    }

    @Override
    public void setView(TriviaView view) {
        this.view = view;
    }

}
