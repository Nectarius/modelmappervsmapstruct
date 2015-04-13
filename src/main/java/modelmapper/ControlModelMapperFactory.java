package modelmapper;

import domain.Control;
import domain.Details;
import org.modelmapper.Condition;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.FactoryBean;
import view.AdminDetailsView;
import view.ControlView;


/**
 * Created by adelfiri on 4/7/15.
 */
public class ControlModelMapperFactory implements FactoryBean<ControlModelMapper> {

    private ControlModelMapper modelMapper = null;

    private ControlModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ControlModelMapper();
            modelMapper.addMappings(new ControlsMap());
            modelMapper.addMappings(new DetailsMap());
        }
        return modelMapper;
    }


    private Condition<Control, ControlView> isEmployee = new Condition<Control, ControlView>() {
        @Override
        public boolean applies(MappingContext<Control, ControlView> context) {
            return modelMapper.getIsEmployee();
        }
    };

    public class DetailsMap extends PropertyMap<Details, AdminDetailsView> {
        protected void configure() {
            //map().setDescription(source.getText());
            //map(source.getDescription()).setDescription(null);
        }
    }

    public class ControlsMap extends PropertyMap<Control, ControlView> {
        protected void configure() {
            //map().setDescription(source.getText());
            map(source.getDetails()).setDetailsView(null);
        }
    }


    @Override
    public ControlModelMapper getObject() throws Exception {
        return getModelMapper();
    }

    @Override
    public Class<?> getObjectType() {
        return ControlModelMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
