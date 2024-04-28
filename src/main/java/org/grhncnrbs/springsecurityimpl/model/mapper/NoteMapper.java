package org.grhncnrbs.springsecurityimpl.model.mapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDTO toDTO(Note entity);

    Note toEntity(NoteDTO dto);

    List<NoteDTO> toDTOs(List<Note> entities);

    Note toEntity(AddNoteDTO dto);
}
