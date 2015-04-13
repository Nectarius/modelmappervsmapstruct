package repository;

import domain.*;
import org.springframework.stereotype.Service;

/**
 * Created by adelfiri on 4/5/15.
 */
@Service
public class FakeRepository {

    public Note findOne(Long id) {
        Note note = new Note();
        note.setText("something ...");
        note.setTitle("red title");
        note.setBrief("brief ...");
        note.setType("common");
        return note;
    }

    public AbstractNote findOneAbstractNote(Long id) {
        VelvetNote velvetNote = new VelvetNote();
        velvetNote.setType("velvet");
        VelvetComment velvetComment = new VelvetComment();
        velvetComment.setTitle("velvet comment");
        velvetComment.setText("something text ...");
        velvetNote.setCommentary(velvetComment);
        velvetNote.setAdvanceTitle("advance title");
        return velvetNote;
    }


    public Control findControl(Long id) {
        Control control = new Control();
        control.setId(55l);
        control.setName("control");
        Details details = new Details();
        details.setName("details name");
        details.setDescription("details description");
        control.setDetails(details);
        return control;
    }
}
