package com.umerscode.Notes.Dao;

import com.umerscode.Notes.Exception.DaoException;
import com.umerscode.Notes.Models.Note;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcNoteDao implements NoteDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcNoteDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();

        String sql = "SELECT * FROM notes";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while(result.next()){
                notes.add(mapRowToNote(result));
            }
        }
        catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to database or server.");
        }

        return notes;
    }

    @Override
    public Note createNote(Note note) {

        Note createdNote = null;

        String sql = "INSERT INTO notes (title, note) VALUES " +
                "(?,?) RETURNING id;";

        try{
            int newNoteId = jdbcTemplate.queryForObject(sql, int.class, note.getTitle(), note.getNote());

            if(newNoteId > 0){
                note = getNoteById(newNoteId);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to database");
        }
            catch(DataIntegrityViolationException e){
            throw new DaoException("Data Integrity violation exception");

        }

        return note;
    }

    @Override
    public Note getNoteById(int id) {

        Note note = null;

        String sql = "SELECT * FROM notes WHERE id = ?";

        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
            if(result.next()){
                note = mapRowToNote(result);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to database");
        }


        return note;
    }

    @Override
    public Note updateNote(int id, Note note) {

        Note updatedNote = null;
        String sql = "UPDATE notes SET title = ?, note = ? WHERE id = ?";

        try{
            int numberOfUpdatedRow = jdbcTemplate.update(sql, note.getTitle(), note.getNote(), id);
            if(numberOfUpdatedRow == 1){
                updatedNote = getNoteById(id);
            }else {
                throw new DaoException("Something went wrong, Unable to update the note");
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to database");
        }
        return updatedNote;
    }


    public Note mapRowToNote(SqlRowSet row){
        Note note = new Note();

        note.setId(row.getInt("id"));
        note.setTitle(row.getString("title"));
        note.setNote(row.getString("note"));

        return note;
    }
}
