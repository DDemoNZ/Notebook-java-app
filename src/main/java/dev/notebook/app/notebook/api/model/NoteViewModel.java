package dev.notebook.app.notebook.api.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoteViewModel {

    @NotEmpty
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String text;
    @NotNull
    private String notebookId;

}
