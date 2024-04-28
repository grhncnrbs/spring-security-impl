package org.grhncnrbs.springsecurityimpl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddStickyNoteDto {

    private String description;
    private String name;
    private String color;
}
