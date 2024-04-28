package org.grhncnrbs.springsecurityimpl.controller;

import lombok.RequiredArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.dto.AddStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.NoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.StickyNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.UpdateStickyNoteDto;
import org.grhncnrbs.springsecurityimpl.service.intf.NoteService;
import org.grhncnrbs.springsecurityimpl.service.intf.StickyNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StickyNoteController {

    @Autowired
    private final StickyNoteService stickyNoteService;

    @Autowired
    private final NoteService noteService;

    @GetMapping("")
    public String home(Model model) {
        List<StickyNoteDto> stickyNoteDTOS = stickyNoteService.allStickyNotes();
        model.addAttribute("stickyNotes", stickyNoteDTOS);
        return "home";
    }

    @GetMapping("sticky-note/{id}")
    public String stickyNote(@PathVariable(name = "id") Long id, Model model) {
        StickyNoteDto stickyNote = stickyNoteService.findById(id);
        List<NoteDto> notes = noteService.getAllNotes(id);
        model.addAttribute("stickyNote", stickyNote);
        model.addAttribute("notes", notes);
        return "sticky-note";
    }

    @GetMapping("edit-sticky-note/{id}")
    public String editStickyNote(@PathVariable(name = "id") Long id, Model model) {
        StickyNoteDto stickyNote = stickyNoteService.findById(id);
        model.addAttribute("stickyNote", stickyNote);
        return "edit-sticky-note";
    }

    @PostMapping("/save")
    public String addNewStickyNote(@ModelAttribute("dto") AddStickyNoteDto dto) {
        stickyNoteService.addStickyNote(dto);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateStickyNote(@ModelAttribute("dto") UpdateStickyNoteDto dto, @PathVariable("id") Long id){
        stickyNoteService.update(dto, id);
        return "redirect:/edit-sticky-note/" + id;
    }
}
