package org.grhncnrbs.springsecurityimpl.service.implemantation;

import org.grhncnrbs.springsecurityimpl.model.dto.AddStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.StickyNoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StickyNoteService {

    AddStickyNoteDto addStickyNote(AddStickyNoteDto dto);

    List<StickyNoteDto> allStickyNotes();

    StickyNoteDto findById(Long id);

    void update(UpdateStickyNoteDto dto , Long id);
}
