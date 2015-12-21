package architecture.mvptest.TriviaCallback;

/**
 * Created by Tiago on 21/12/2015.
 */
public interface TriviaCallback<T> {
    void success(T t);
    void serverFailure(String error);
    void networkFailure(String error);
}
