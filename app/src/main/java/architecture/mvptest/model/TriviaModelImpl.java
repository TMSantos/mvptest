package architecture.mvptest.model;

import architecture.mvptest.TriviaCallback.TriviaCallback;
import architecture.mvptest.rest.RestClient;
import architecture.mvptest.rest.restmodels.TriviaResponse;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Tiago on 21/12/2015.
 */
public class TriviaModelImpl implements TriviaModel {

    public TriviaModelImpl() {
    }

    @Override
    public void getTriviaText(final TriviaCallback<TriviaEntity> callback) {
        RestClient.instance.getRandomTrivia()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TriviaResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.networkFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(TriviaResponse triviaResponse) {
                        callback.success(new TriviaEntity(triviaResponse.getText()));
                    }
                });

    }
}
