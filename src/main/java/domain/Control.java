package domain;

/**
 * Created by adelfiri on 4/11/15.
 */
public class Control {

    private Long id;

    private String name;

    private Details details;

    public String getStatus(String date) {
        return "temporary";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
