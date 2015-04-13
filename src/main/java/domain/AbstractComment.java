package domain;

/**
 * Created by adelfiri on 4/8/15.
 */
public abstract class AbstractComment {

    private String text;

    public abstract String getTitle();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
