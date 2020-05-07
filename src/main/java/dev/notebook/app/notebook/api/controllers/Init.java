package dev.notebook.app.notebook.api.controllers;

import dev.notebook.app.notebook.entity.Note;
import dev.notebook.app.notebook.entity.Notebook;
import dev.notebook.app.notebook.service.NoteService;
import dev.notebook.app.notebook.service.NotebookService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Init {

    private final NotebookService notebookService;
    private final NoteService noteService;

    public Init(NotebookService notebookService, NoteService noteService) {
        this.notebookService = notebookService;
        this.noteService = noteService;
    }

    @PostConstruct
    public void init() {

        Notebook notebook = new Notebook();
        notebook.setName("New notebook");
        Notebook saveNotebook = notebookService.saveNotebook(notebook);

        Note note = new Note();
        note.setText("Text");
        note.setName("New note");
        note.setNotebook(saveNotebook);
        Note note1 = noteService.saveNote(note);

        saveNotebook.getNotes().add(note1);
        notebookService.saveNotebook(saveNotebook);

        Notebook secondNotebook = new Notebook();
        secondNotebook.setName("Second notebook");
        Notebook secondSavedNotebook = notebookService.saveNotebook(secondNotebook);

        Note noteNew = new Note();
        noteNew.setText("Enter the text..");
        noteNew.setName("Hello!");
        noteNew.setNotebook(secondSavedNotebook);
        Note note1Saved = noteService.saveNote(noteNew);

        saveNotebook.getNotes().add(note1Saved);
        notebookService.saveNotebook(secondSavedNotebook);
    }

}
