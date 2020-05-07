package dev.notebook.app.notebook.api.model;

import dev.notebook.app.notebook.entity.Note;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotebookViewModel {

    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @NotNull
    private List<Note> notes;

}
