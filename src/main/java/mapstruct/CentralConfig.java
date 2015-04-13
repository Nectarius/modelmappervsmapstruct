package mapstruct;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Created by adelfiri on 4/12/15.
 */
@MapperConfig(
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG,
        unmappedTargetPolicy = ReportingPolicy.DEFAULT,
        componentModel = "spring"
)
public interface CentralConfig {


}
