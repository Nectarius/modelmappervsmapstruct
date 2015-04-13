package modelmapper;

import domain.Note;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.FactoryBean;
import view.NoteView;
import view.SimpleNoteView;


/**
 * Created by adelfiri on 4/7/15.
 */
public class ModelMapperFactory implements FactoryBean<ModelMapper> {

    private ModelMapper modelMapper = null;


    private Converter<Note, SimpleNoteView> noteConverter = new AbstractConverter<Note, SimpleNoteView>() {
        protected SimpleNoteView convert(Note note) {
            SimpleNoteView noteView = new SimpleNoteView();
            noteView.setDescription(note.getTitle() + ' ' + note.getBrief());
            noteView.setType(note.getType());
            return noteView;
        }
    };

    private Condition<Note, NoteView> typeIsCommon = new Condition<Note, NoteView>() {
        @Override
        public boolean applies(MappingContext<Note, NoteView> context) {
            System.out.println("test");
            Note note = (Note) context.getParent().getSource();
            boolean flag = note.getType().equals("common");
            return flag;
        }
    };

    public class NoteMap extends PropertyMap<Note, NoteView> {
        protected void configure() {
            //map().setDescription(source.getText());
            when(typeIsCommon).map().setCommentary(source.getTitle());
        }
    }

    /*public class DetailsMap extends PropertyMap<Details, DetailsView> {
        protected void configure() {
            //map().setDescription(source.getText());
            when(isEmployee).map()));
        }
    }*/

    private ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.addConverter(noteConverter);
            modelMapper.addMappings(new NoteMap());
        }
        return modelMapper;
    }

    @Override
    public ModelMapper getObject() throws Exception {
        return getModelMapper();
    }

    @Override
    public Class<?> getObjectType() {
        return ModelMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
