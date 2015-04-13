package domain;

/**
 * Created by adelfiri on 4/8/15.
 */
public abstract class AbstractNote {

    private String type;

    public abstract AbstractComment getCommentary();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
