package view;

/**
 * if employee AdminDetails else UserDetailsView
 * <p/>
 * Created by adelfiri on 4/11/15.
 */
public class ControlView {

    private String name;

    private String status;

    private DetailsView detailsView;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DetailsView getDetailsView() {
        return detailsView;
    }

    public void setDetailsView(DetailsView detailsView) {
        this.detailsView = detailsView;
    }
}
