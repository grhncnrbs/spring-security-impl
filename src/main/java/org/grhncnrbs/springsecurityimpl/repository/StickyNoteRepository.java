package org.grhncnrbs.springsecurityimpl.repository;

import org.grhncnrbs.springsecurityimpl.model.entity.StickyNote;
import org.grhncnrbs.springsecurityimpl.model.enums.StickyNoteStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StickNoteRepository extends JpaRepository<StickNoteRepository, Long> {

    List<StickyNote> findAllByStatus(StickyNoteStatus status);
}
