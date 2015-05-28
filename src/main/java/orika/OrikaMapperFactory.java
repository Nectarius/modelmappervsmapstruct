package orika;

import domain.Note;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Property;
import ma.glasnost.orika.metadata.Type;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.FactoryBean;
import view.NoteView;
import view.SimpleNoteView;

import java.math.BigDecimal;

/**
 * Created by adelfiri on 5/28/15.
 */
public class OrikaMapperFactory implements FactoryBean<MapperFacade> {

    private MapperFactory mapperFactory = null;

    private MapperFacade mapperFacade = null;

    private MapperFacade getMapperFacade() {
        if(mapperFacade == null) {
            mapperFacade = getMapperFactory().getMapperFacade();
        }
        return mapperFacade;
    }

    private MapperFactory getMapperFactory() {
        if (mapperFactory == null) {
            mapperFactory = new DefaultMapperFactory.Builder().build();
            //String expression = "description:{getBrief().concat(getTitle())|setBrief('not supported yet')|type=java.lang.String}";
            mapperFactory.classMap(Note.class, SimpleNoteView.class)
                    .customize(
                            new CustomMapper<Note, SimpleNoteView>() {
                                @Override
                                public void mapAtoB(Note b, SimpleNoteView a, ma.glasnost.orika.MappingContext context) {
                                    a.setDescription(b.getTitle() + " " + b.getBrief());
                                }

                            })
                    .register();
        }
        return mapperFactory;
    }

    @Override
    public MapperFacade getObject() throws Exception {
        return getMapperFacade();
    }

    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
