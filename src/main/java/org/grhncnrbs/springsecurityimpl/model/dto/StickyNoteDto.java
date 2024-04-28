package org.grhncnrbs.springsecurityimpl.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.enums.StickyNoteStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StickyNoteDto {

    private Long id;
    private String description;
    private String name;
    private StickyNoteStatus status;
    private String color;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
