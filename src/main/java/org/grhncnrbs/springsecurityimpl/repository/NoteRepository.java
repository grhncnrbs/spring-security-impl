package org.grhncnrbs.springsecurityimpl.repository;

import org.grhncnrbs.springsecurityimpl.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByStickyNoteIdOrderByIdDesc(Long id);

}
