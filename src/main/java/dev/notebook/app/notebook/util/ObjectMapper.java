package dev.notebook.app.notebook.util;

import dev.notebook.app.notebook.api.model.NoteViewModel;
import dev.notebook.app.notebook.api.model.NotebookViewModel;
import dev.notebook.app.notebook.entity.Note;
import dev.notebook.app.notebook.entity.Notebook;
import dev.notebook.app.notebook.service.NotebookService;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    private final NotebookService notebookService;

    public ObjectMapper(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    public NoteViewModel convertNoteEntityToViewModel(Note note) {
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setId(String.valueOf(note.getId()));
        noteViewModel.setName(note.getName());
        noteViewModel.setText(note.getText());
        noteViewModel.setNotebookId(String.valueOf(note.getNotebook().getId()));
        return noteViewModel;
    }

    public Note convertNoteViewModelToEntity(NoteViewModel noteViewModel) {
        Note note = new Note();
        if (noteViewModel.getId() != null) {
            note.setId(Long.valueOf(noteViewModel.getId()));
        }
        note.setName(noteViewModel.getName());
        note.setNotebook(notebookService.getNotebookById(
                Long.valueOf(noteViewModel.getNotebookId())));
        note.setText(noteViewModel.getText());
        return note;
    }

    public Notebook convertNotebookViewModelToEntity(NotebookViewModel notebookViewModel) {
        Notebook notebook = new Notebook();
        if (notebookViewModel.getId() != null) {
            notebook.setId(Long.valueOf(notebookViewModel.getId()));
        }
        notebook.setName(notebookViewModel.getName());
        return notebook;
    }

    public NotebookViewModel convertNotebookEntityToViewModel(Notebook notebook) {
        NotebookViewModel notebookViewModel = new NotebookViewModel();
        notebookViewModel.setId(String.valueOf(notebook.getId()));
        notebookViewModel.setName(notebook.getName());
        notebookViewModel.setNotes(notebook.getNotes());
        return notebookViewModel;
    }

}
