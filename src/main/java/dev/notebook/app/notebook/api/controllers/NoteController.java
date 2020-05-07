package dev.notebook.app.notebook.api.controllers;

import dev.notebook.app.notebook.api.model.NoteViewModel;
import dev.notebook.app.notebook.service.NoteService;
import dev.notebook.app.notebook.util.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/notes")
public class NoteController {

    private final NoteService noteService;
    private final ObjectMapper objectMapper;

    public NoteController(NoteService noteService, ObjectMapper objectMapper) {
        this.noteService = noteService;
        this.objectMapper = objectMapper;
    }

    @PutMapping
    public NoteViewModel saveUpdateNote(@RequestBody NoteViewModel noteViewModel) {
        return objectMapper.convertNoteEntityToViewModel(noteService
                .saveNote(objectMapper.convertNoteViewModelToEntity(noteViewModel)));
    }

    @GetMapping
    public List<NoteViewModel> getAllNotes() {
        var notes = noteService.getAllNotes().stream()
                .map(objectMapper::convertNoteEntityToViewModel)
                .collect(Collectors.toList());

        return notes;
    }

    @GetMapping("/notebook/{id}")
    public List<NoteViewModel> getAllNotesFromNotebookId(@PathVariable Long id) {
        return noteService.getAllNotesFromNotebookId(id).stream()
                .map(objectMapper::convertNoteEntityToViewModel)
                .collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public void deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
    }

}
