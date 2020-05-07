package dev.notebook.app.notebook.service.impl;

import dev.notebook.app.notebook.entity.Notebook;
import dev.notebook.app.notebook.repository.NotebookRepository;
import dev.notebook.app.notebook.service.NotebookService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class NotebookServiceImpl implements NotebookService {

    private final NotebookRepository notebookRepository;

    public NotebookServiceImpl(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public Notebook getNotebookById(Long id) {
        return notebookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteNotebookById(Long id) {
        notebookRepository.deleteById(id);
    }

    @Override
    public List<Notebook> getAllNotebooks() {
        return notebookRepository.findAll();
    }

    @Override
    public Notebook saveNotebook(Notebook notebook) {
        return notebookRepository.save(notebook);
    }

}
