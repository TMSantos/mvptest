package architecture.mvptest.rest.restmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tiago on 21/12/2015.
 */
public class TriviaResponse {

    @SerializedName("text")
    private String text;
    @SerializedName("number")
    private int number;
    @SerializedName("found")
    private boolean found;
    @SerializedName("type")
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
