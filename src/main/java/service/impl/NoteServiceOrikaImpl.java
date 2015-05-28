package service.impl;

import domain.Note;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
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
 * Created by adelfiri on 5/28/15.
 */
@Service
public class NoteServiceOrikaImpl implements NoteService {

    @Autowired
    private FakeRepository fakeRepository;

    @Autowired
    private MapperFacade mapperFacade;



    @Override
    public NoteView findOne(Long id) {

        return null;
    }

    @Override
    public SimpleNoteView findSimpleOne(Long id) {
        Note note = fakeRepository.findOne(id);
        System.out.println("NoteServiceOrikaImpl : id = [" + id + "]");
        return mapperFacade.map(note, SimpleNoteView.class);
    }

    @Override
    public VelvetNoteView findVelvetNote(Long id) {
        return null;
    }

    @Override
    public ControlView findControl(Long id) {
        return null;
    }
}
