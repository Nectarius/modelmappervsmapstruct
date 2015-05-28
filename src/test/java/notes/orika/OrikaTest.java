package notes.orika;

import ma.glasnost.orika.metadata.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.NoteService;
import view.SimpleNoteView;

/**
 * Created by adelfiri on 5/28/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class OrikaTest {

    @Autowired
    @Qualifier("noteServiceOrikaImpl")
    private NoteService noteService;

    @Test
    public void twoInOne() {



        SimpleNoteView note = noteService.findSimpleOne(77l);

        System.out.println("note.getDescription() = " + note.getDescription());

        System.out.println("note.getType() = " + note.getType());

        //modelMapper.validate();

        org.junit.Assert.assertEquals("red title brief ...", note.getDescription());

    }

}
