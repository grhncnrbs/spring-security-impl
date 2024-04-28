package org.grhncnrbs.springsecurityimpl.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.dto.AddStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.StickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.UpdateStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.entity.StickyNote;
import org.grhncnrbs.springsecurityimpl.model.enums.StickyNoteStatus;
import org.grhncnrbs.springsecurityimpl.model.mapper.StickyNoteMapper;
import org.grhncnrbs.springsecurityimpl.repository.StickyNoteRepository;
import org.grhncnrbs.springsecurityimpl.service.intf.StickyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StickyNoteServiceImpl implements StickyNoteService {

    @Autowired
    private final StickyNoteRepository stickyNoteRepository;
    @Autowired
    private final StickyNoteMapper stickyNoteMapper;

    @Override
    public AddStickyNoteDto addStickyNote(AddStickyNoteDto dto) {
        StickyNote entity = stickyNoteMapper.toEntity(dto);
        entity.setStatus(StickyNoteStatus.ACTIVE);
        StickyNote savedEntity = stickyNoteRepository.save(entity);
        AddStickyNoteDto addStickyNoteDTO = this.stickyNoteMapper.toAddDto(savedEntity);
        return addStickyNoteDTO;
    }

    @Override
    public List<StickyNoteDto> allStickyNotes() {
        List<StickyNote> all = stickyNoteRepository.findAllByStatus(StickyNoteStatus.ACTIVE);
        return stickyNoteMapper.toDtos(all);
    }

    @Override
    public StickyNoteDto findById(Long id) {
        Optional<StickyNote> entity = stickyNoteRepository.findById(id);
        return stickyNoteMapper.toDto(entity.get());
    }

    @Override
    public void update(UpdateStickyNoteDto dto, Long id) {
        StickyNote entity = this.stickyNoteMapper.toEntity(dto);
        entity.setId(id);
        stickyNoteRepository.save(entity);
    }
}
