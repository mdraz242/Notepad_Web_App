package notepad_web_app.Repositry;

import notepad_web_app.Entity.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
