package domain;

/**
 * Created by adelfiri on 4/8/15.
 */
public class VelvetNote extends AbstractNote {

    private AbstractComment commentary = null;

    private String advanceTitle = null;

    public String getAdvanceTitle() {
        return advanceTitle;
    }

    public void setAdvanceTitle(String advanceTitle) {
        this.advanceTitle = advanceTitle;
    }

    public void setCommentary(AbstractComment commentary) {
        this.commentary = commentary;
    }

    @Override
    public AbstractComment getCommentary() {
        return commentary;
    }
}
