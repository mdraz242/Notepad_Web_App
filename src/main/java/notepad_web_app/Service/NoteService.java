package notepad_web_app.Service;


import notepad_web_app.Entity.Note;
import notepad_web_app.Repositry.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    public List<Note>findAll() {
        return (List<Note>) repo.findAll();
    }

    public void SaveNote(Note note) {
       note.setCreatedAt(LocalDateTime.now());
       note.setUpdatedAt(LocalDateTime.now());
       repo.save(note);
    }

    public Note findById(Long id) {
        return repo.findById(id).orElse(null);
    }


    public void updateNote(Note note) {
        note.setUpdatedAt(LocalDateTime.now());
        repo.save(note);
    }

    public void deleteNote(Long id) {
        repo.deleteById(id);
    }
}
