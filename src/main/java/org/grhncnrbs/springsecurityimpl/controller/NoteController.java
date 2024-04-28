package org.grhncnrbs.springsecurityimpl.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.grhncnrbs.springsecurityimpl.model.dto.AddNoteDto;
import org.grhncnrbs.springsecurityimpl.model.dto.NoteDto;
import org.grhncnrbs.springsecurityimpl.service.intf.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;

    @PostMapping("/add/{stickyNoteId}")
    public String addNote(@ModelAttribute("dto") AddNoteDto dto, @PathVariable("stickyNoteId") Long stickyNoteId) {
        this.noteService.add(dto, stickyNoteId);
        return "redirect:/sticky-note/" + stickyNoteId;
    }

    @GetMapping("/delete/{noteId}/{stickyNoteId}")
    public String delete(@PathVariable("noteId") Long noteId, @PathVariable("stickyNoteId") Long stickyNoteId) {
        this.noteService.delete(noteId);
        return "redirect:/sticky-note/" + stickyNoteId;
    }

    @GetMapping("")
    public String myNotes(Model model) {
        List<NoteDto> allNotes = this.noteService.getAllNotes();
        model.addAttribute("notes" , allNotes);
        return "my-notes";
    }
}
