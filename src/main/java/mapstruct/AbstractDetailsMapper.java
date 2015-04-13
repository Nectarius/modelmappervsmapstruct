package mapstruct;

import domain.Details;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import view.DetailsView;


/**
 * Created by adelfiri on 4/12/15.
 */

@Component
public class AbstractDetailsMapper {

    @Autowired
    private DetailsMapper detailsMapper;

    public DetailsView fromDetailsView(Details details) {
        return detailsMapper.detailsToDetailsView(details);
    }

    public DetailsView fromDetailsView(Details details, Boolean isEmployee) {
        if (isEmployee) {
            return detailsMapper.adminDetailsToDetailsView(details, isEmployee);
        } else {
            return detailsMapper.detailsToDetailsView(details);
        }

    }

    public Details fromDetails(DetailsView details, @TargetType Class<DetailsView> targetClass) {
        // not supported yet ...
        return new Details();
    }

}
