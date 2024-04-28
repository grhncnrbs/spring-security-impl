package org.grhncnrbs.springsecurityimpl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
