package com.umerscode.Notes.Controller;

import com.umerscode.Notes.Dao.JdbcNoteDao;
import com.umerscode.Notes.Models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("note")
@CrossOrigin
public class NoteController {

    private final JdbcNoteDao jdbcNoteDao;

    @Autowired
    public NoteController(JdbcNoteDao jdbcNoteDao) {
        this.jdbcNoteDao = jdbcNoteDao;
    }

    @GetMapping("/all")
    public List<Note> getAllNotes(){
        return jdbcNoteDao.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable int id){
        return jdbcNoteDao.getNoteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note createNote(@RequestBody Note note){
        return jdbcNoteDao.createNote(note);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Note updateNote(@PathVariable int id, @RequestBody Note note){
        return jdbcNoteDao.updateNote(id, note);
    }
}
