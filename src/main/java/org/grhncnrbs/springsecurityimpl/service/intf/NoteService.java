package org.grhncnrbs.springsecurityimpl.service.intf;

import org.grhncnrbs.springsecurityimpl.model.dto.AddNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.NoteDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    NoteDto add(AddNoteDto dto, Long stickyNoteId);

    List<NoteDto> getAllNotes(Long stickyNoteId);

    void delete(Long id);

    List<NoteDto> getAllNotes();
}
