package mapstruct;

import domain.AbstractNote;
import domain.Control;
import domain.Note;
import domain.VelvetNote;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import view.ControlView;
import view.NoteView;
import view.SimpleNoteView;
import view.VelvetNoteView;

/**
 * Created by adelfiri on 4/5/15.
 */
@Mapper(config = CentralConfig.class, imports = {VelvetNote.class}, uses = {AbstractDetailsMapper.class})
public interface NoteMapper {

    @Mapping(target = "description",
            expression = "java(  String.valueOf(note.getTitle() + ' ' + note.getBrief()) )")
    SimpleNoteView noteToSimpleNoteView(Note note);

    Note noteViewToNote(NoteView noteView);

    @Mapping(target = "commentary",
            expression = "java(  NoteConditions.getCommentaryByType(note) )")
    NoteView noteToNoteView(Note note);

    @Mappings({
            @Mapping(target = "commentary",
                    expression = "java( ((VelvetNote)note).getCommentary().toString()  )"),
            @Mapping(target = "advanceTitle",
                    expression = "java( ((VelvetNote)note).getAdvanceTitle()  )")
    })
    VelvetNoteView abstractNoteToVelvetNoteView(AbstractNote note);

    @Mapping(source = "control.details", target = "detailsView")
    ControlView controlToControlView(Control control);

    @Mapping(target = "detailsView", expression = "java(abstractDetailsMapper.fromDetailsView(control.getDetails(), isEmployee))")
    ControlView controlToControlView(Control control, Boolean isEmployee);


}
