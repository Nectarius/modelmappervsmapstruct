package domain;

/**
 * Created by adelfiri on 4/8/15.
 */
public class VelvetComment extends AbstractComment {

    private String title = null;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String toString() {
        return getText();
    }


}
