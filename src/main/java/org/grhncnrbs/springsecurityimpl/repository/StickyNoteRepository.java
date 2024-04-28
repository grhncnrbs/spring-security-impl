package org.grhncnrbs.springsecurityimpl.repository;

import org.grhncnrbs.springsecurityimpl.model.entity.StickyNote;
import org.grhncnrbs.springsecurityimpl.model.enums.StickyNoteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickyNoteRepository extends JpaRepository<StickyNote, Long> {

    List<StickyNote> findAllByStatus(StickyNoteStatus status);


}
