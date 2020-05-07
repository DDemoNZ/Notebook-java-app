package dev.notebook.app.notebook.repository;

import dev.notebook.app.notebook.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
