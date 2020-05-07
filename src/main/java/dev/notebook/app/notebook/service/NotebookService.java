package dev.notebook.app.notebook.service;

import dev.notebook.app.notebook.entity.Notebook;
import java.util.List;

public interface NotebookService {

    Notebook saveNotebook(Notebook notebook);

    List<Notebook> getAllNotebooks();

    void deleteNotebookById(Long id);

    Notebook getNotebookById(Long id);

}
