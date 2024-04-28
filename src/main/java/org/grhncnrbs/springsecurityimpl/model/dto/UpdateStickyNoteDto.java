package org.grhncnrbs.springsecurityimpl.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.enums.StickyNoteStatus;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateStickyNoteDto {

    private String description;
    private String name;
    private String color;
    private StickyNoteStatus status;
}
