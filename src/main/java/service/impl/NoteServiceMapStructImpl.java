package service.impl;

import domain.AbstractNote;
import domain.Control;
import domain.Note;
import mapstruct.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FakeRepository;
import service.NoteService;
import view.ControlView;
import view.NoteView;
import view.SimpleNoteView;
import view.VelvetNoteView;

/**
 * Created by adelfiri on 4/5/15.
 */
@Service
public class NoteServiceMapStructImpl implements NoteService {

    @Autowired
    private FakeRepository fakeRepository;

    @Autowired
    private NoteMapper noteMapper;

    public NoteView findOne(Long id) {
        Note note = fakeRepository.findOne(id);
        System.out.println("NoteServiceMapStructImpl : id = [" + id + "]");
        return noteMapper.noteToNoteView(note);
    }

    @Override
    public SimpleNoteView findSimpleOne(Long id) {
        Note note = fakeRepository.findOne(id);
        System.out.println("NoteServiceMapStructImpl : id = [" + id + "]");
        return noteMapper.noteToSimpleNoteView(note);
    }

    public VelvetNoteView findVelvetNote(Long id) {
        AbstractNote note = fakeRepository.findOneAbstractNote(44l);
        System.out.println("NoteServiceModelMapperImpl : id = [" + id + "]");
        return noteMapper.abstractNoteToVelvetNoteView(note);
    }

    @Override
    public ControlView findControl(Long id) {
        Control control = fakeRepository.findControl(44l);
        return noteMapper.controlToControlView(control, true);
    }

}
