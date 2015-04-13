package service.impl;

import domain.AbstractNote;
import domain.Control;
import domain.Note;
import modelmapper.ControlModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FakeRepository;
import service.NoteService;
import view.ControlView;
import view.NoteView;
import view.SimpleNoteView;
import view.VelvetNoteView;

/**
 * Created by adelfiri on 4/6/15.
 */
@Service
public class NoteServiceModelMapperImpl implements NoteService {

    @Autowired
    private FakeRepository fakeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ControlModelMapper controlModelMapper;

    public VelvetNoteView findVelvetNote(Long id) {
        AbstractNote note = fakeRepository.findOneAbstractNote(44l);
        System.out.println("NoteServiceModelMapperImpl : id = [" + id + "]");
        return modelMapper.map(note, VelvetNoteView.class);
    }

    @Override
    public ControlView findControl(Long id) {
        Control control = fakeRepository.findControl(44l);
        return controlModelMapper.controlToControlView(control, true);

    }

    public NoteView findOne(Long id) {
        Note note = fakeRepository.findOne(id);
        System.out.println("NoteServiceModelMapperImpl : id = [" + id + "]");
        return modelMapper.map(note, NoteView.class);
    }

    public SimpleNoteView findSimpleOne(Long id) {
        Note note = fakeRepository.findOne(id);
        System.out.println("NoteServiceModelMapperImpl : id = [" + id + "]");
        return modelMapper.map(note, SimpleNoteView.class);
    }

}
