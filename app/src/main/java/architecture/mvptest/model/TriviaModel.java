package architecture.mvptest.model;

import architecture.mvptest.triviacallback.TriviaCallback;

/**
 * Created by Tiago on 21/12/2015.
 */
public interface TriviaModel{
    void getTriviaText(TriviaCallback<TriviaEntity>  callback);
}
