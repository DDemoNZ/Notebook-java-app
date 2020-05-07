package dev.notebook.app.notebook.repository;

import dev.notebook.app.notebook.entity.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {

}
