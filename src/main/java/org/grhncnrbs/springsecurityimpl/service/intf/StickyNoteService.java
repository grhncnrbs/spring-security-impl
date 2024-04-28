package org.grhncnrbs.springsecurityimpl.service.intf;

import org.grhncnrbs.springsecurityimpl.model.dto.AddStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.StickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.UpdateStickyNoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StickyNoteService {

    AddStickyNoteDto addStickyNote(AddStickyNoteDto dto);

    List<StickyNoteDto> allStickyNotes();

    StickyNoteDto findById(Long id);

    void update(UpdateStickyNoteDto dto , Long id);
}
