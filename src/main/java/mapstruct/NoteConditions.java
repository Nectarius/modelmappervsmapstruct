package mapstruct;

import domain.Note;

/**
 * Created by adelfiri on 4/8/15.
 */
public class NoteConditions {

    public static String getCommentaryByType(Note note) {
        if (note.getType().equals("common")) {
            return note.getTitle();
        }
        return "";
    }

    ;

}
