package com.umerscode.Notes.Dao;

import com.umerscode.Notes.Models.Note;

import java.util.List;

public interface NoteDao {

    List<Note> getAllNotes();
    Note createNote(Note note);
    Note getNoteById(int id);

}
