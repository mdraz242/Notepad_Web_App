package notepad_web_app.Controller;



import notepad_web_app.Entity.Note;
import notepad_web_app.Service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteContorller {

    NoteService noteService;

    public NoteContorller(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String viewModel(Model model) {
      model.addAttribute("notes", noteService.findAll());
      return "index";
    }

    @GetMapping("/view-notes/{id}")
    public String viewNote(@PathVariable long id, Model model) {
        model.addAttribute("note", noteService.findById(id));
        return "view-notes";
    }


    @GetMapping("/add")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());
        return "add-note";
    }

    @PostMapping("/save")
    public String saveNote (@ModelAttribute Note note){
        noteService.SaveNote(note);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.findById(id));
        return "edit-note";
    }

    @PostMapping("/update")
    public String updateNote (@ModelAttribute Note note){
        noteService.updateNote(note);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/";
    }

}
