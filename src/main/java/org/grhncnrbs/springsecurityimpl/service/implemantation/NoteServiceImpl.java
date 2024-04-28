package org.grhncnrbs.springsecurityimpl.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.dto.AddNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.NoteDto;
import org.grhncnrbs.springsecurityimpl.model.entity.Note;
import org.grhncnrbs.springsecurityimpl.model.mapper.NoteMapper;
import org.grhncnrbs.springsecurityimpl.repository.NoteRepository;
import org.grhncnrbs.springsecurityimpl.service.intf.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    @Autowired
    private final NoteRepository noteRepository;
    @Autowired
    private final NoteMapper noteMapper;

    @Override
    public NoteDto add(AddNoteDto dto, Long stickyNoteId) {
        Note entity = this.noteMapper.toEntity(dto);
        entity.setStickyNoteId(stickyNoteId);
        Note savedEntity = this.noteRepository.save(entity);
        return this.noteMapper.toDTO(savedEntity);
    }

    @Override
    public List<NoteDto> getAllNotes(Long stickyNoteId) {
        List<Note> notes = this.noteRepository.findAllByStickyNoteIdOrderByIdDesc(stickyNoteId);
        return this.noteMapper.toDTOs(notes);
    }

    @Override
    public void delete(Long id) {
        this.noteRepository.deleteById(id);
    }

    @Override
    public List<NoteDto> getAllNotes() {
        List<Note> notes = this.noteRepository.findAll();
        return this.noteMapper.toDTOs(notes);
    }
}
