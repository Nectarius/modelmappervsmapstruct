package notes.modelmapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.NoteService;
import view.NoteView;
import view.SimpleNoteView;
import view.VelvetNoteView;

/**
 * Created by nectarius on 18.05.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class NotesTest {


    @Autowired
    @Qualifier("noteServiceModelMapperImpl")
    private NoteService noteService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void twoInOne() {

        SimpleNoteView note = noteService.findSimpleOne(77l);

        System.out.println("note.getDescription() = " + note.getDescription());

        System.out.println("note.getType() = " + note.getType());

        //modelMapper.validate();

        org.junit.Assert.assertEquals("red title brief ...", note.getDescription());

    }

    @Test
    public void withConditions() {

        NoteView note = noteService.findOne(88l);

        System.out.println("note.getDescription() = " + note.getDescription());

        System.out.println("note.getCommentary() = " + note.getCommentary());

        System.out.println("note.getType() = " + note.getType());

        //modelMapper.validate();

        org.junit.Assert.assertEquals("red title", note.getCommentary());

    }

    @Test
    public void withGenerics() {

        VelvetNoteView note = noteService.findVelvetNote(44l);

        System.out.println("note.getDescription() = " + note.getDescription());

        System.out.println("note.getCommentary() = " + note.getCommentary());

        System.out.println("note.getType() = " + note.getType());

        System.out.println("note.getTitle() = " + note.getTitle());

        System.out.println("note.getAdvanceTitle() = " + note.getAdvanceTitle());

        org.junit.Assert.assertEquals("something text ...", note.getCommentary());
        org.junit.Assert.assertEquals("advance title", note.getAdvanceTitle());

    }


}
