package mapstruct;

import domain.Details;
import org.mapstruct.Mapper;
import view.AdminDetailsView;
import view.DetailsView;

/**
 * Created by adelfiri on 4/11/15.
 */
@Mapper(componentModel = "spring")
public interface DetailsMapper {


    DetailsView detailsToDetailsView(Details details);

    AdminDetailsView adminDetailsToDetailsView(Details details, Boolean isEmployee);

}
