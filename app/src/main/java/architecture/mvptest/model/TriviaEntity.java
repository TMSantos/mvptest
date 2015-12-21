package architecture.mvptest.model;

/**
 * Created by Tiago on 21/12/2015.
 */
public class TriviaEntity {

    private String triviaText;

    public TriviaEntity(String triviaText) {
        this.triviaText = triviaText;
    }

    public String getTriviaText() {
        return triviaText;
    }

    public void setTriviaText(String triviaText) {
        this.triviaText = triviaText;
    }
}
