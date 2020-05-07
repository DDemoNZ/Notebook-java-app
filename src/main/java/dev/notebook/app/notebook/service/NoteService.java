package dev.notebook.app.notebook.service;

import dev.notebook.app.notebook.entity.Note;
import java.util.List;

public interface NoteService {

    void deleteNoteById(Long id);

    Note saveNote(Note note);

    List<Note> getAllNotesFromNotebookId(Long id);

    List<Note> getAllNotes();

}
