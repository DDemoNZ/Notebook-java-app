package dev.notebook.app.notebook.service.impl;

import dev.notebook.app.notebook.entity.Note;
import dev.notebook.app.notebook.repository.NoteRepository;
import dev.notebook.app.notebook.service.NoteService;
import dev.notebook.app.notebook.service.NotebookService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NotebookService notebookService;

    public NoteServiceImpl(NoteRepository noteRepository, NotebookService notebookService) {
        this.noteRepository = noteRepository;
        this.notebookService = notebookService;
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotesFromNotebookId(Long id) {
        return notebookService.getNotebookById(id).getNotes();
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

}
