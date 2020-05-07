package dev.notebook.app.notebook.api.controllers;

import dev.notebook.app.notebook.api.model.NotebookViewModel;
import dev.notebook.app.notebook.entity.Notebook;
import dev.notebook.app.notebook.service.NotebookService;
import dev.notebook.app.notebook.util.ObjectMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ValidationException;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/api/notebooks")
public class NotebookController {

    private final ObjectMapper objectMapper;
    private final NotebookService notebookService;

    public NotebookController(ObjectMapper objectMapper, NotebookService notebookService) {
        this.objectMapper = objectMapper;
        this.notebookService = notebookService;
    }

    @PutMapping
    public Notebook saveUpdateNotebook(@RequestBody NotebookViewModel notebookViewModel,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }

        var notebookEntity = objectMapper.convertNotebookViewModelToEntity(notebookViewModel);
        return notebookService.saveNotebook(notebookEntity);
    }

    @GetMapping
    public List<NotebookViewModel> getAllNotebooks() {
        var allCategories = notebookService.getAllNotebooks().stream()
                .map(objectMapper::convertNotebookEntityToViewModel)
                .collect(Collectors.toList());
        return allCategories;
    }

    @DeleteMapping("/{id}")
    public void deleteNotebookById(@PathVariable Long id) {
        notebookService.deleteNotebookById(id);
    }

}
