package org.grhncnrbs.springsecurityimpl.model.mapper;
import org.grhncnrbs.springsecurityimpl.model.dto.AddNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.NoteDto;
import org.grhncnrbs.springsecurityimpl.model.entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDto toDTO(Note entity);

    Note toEntity(NoteDto dto);

    List<NoteDto> toDTOs(List<Note> entities);

    Note toEntity(AddNoteDto dto);
}
