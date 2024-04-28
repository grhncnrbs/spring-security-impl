package org.grhncnrbs.springsecurityimpl.model.mapper;

import org.grhncnrbs.springsecurityimpl.model.dto.AddStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.StickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.UpdateStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.entity.StickyNote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StickyNoteMapper {

    StickyNoteDto toDto(StickyNote entity);

    StickyNote toEntity(StickyNoteDto dto);

    List<StickyNote> toEntities(List<StickyNoteDto> dtos);

    List<StickyNoteDto> toDtos(List<StickyNote> entities);

    StickyNote toEntity(AddStickyNoteDto dto);

    AddStickyNoteDto toAddDto(StickyNote savedEntity);

    StickyNote toEntity(UpdateStickyNoteDto dto);
}
