package service;

import view.ControlView;
import view.NoteView;
import view.SimpleNoteView;
import view.VelvetNoteView;

/**
 * Created by adelfiri on 4/7/15.
 */
public interface NoteService {

    NoteView findOne(Long id);

    SimpleNoteView findSimpleOne(Long id);

    VelvetNoteView findVelvetNote(Long id);

    ControlView findControl(Long id);
}
