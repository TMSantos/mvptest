package architecture.mvptest.view;

/**
 * Created by Tiago on 21/12/2015.
 */
public interface TriviaView {
    void setTriviaText(String text);
    void onServerFailure(String error);
    void onNetworkFailure(String error);
}
