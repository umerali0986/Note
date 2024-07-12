package com.umerscode.Notes;

import com.umerscode.Notes.Dao.JdbcNoteDao;
import com.umerscode.Notes.Exception.DaoException;
import com.umerscode.Notes.Models.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcNoteDaoTest extends BaseDaoTest{

    private final Note  NOTE_1 = new Note(1,"Grocery", "1.banana 2.tomato 3. onion", false);
    private final Note  NOTE_2 = new Note(2,"ToDo", "1.study 2.soccer",false);

    private JdbcNoteDao sut;

    @Before
    public void setUp(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcNoteDao(jdbcTemplate);
    }

    @Test
    public void getAllNotes_given_valid_values_return_list(){
        List<Note> result = sut.getAllNotes();
        assertNotNull(result);
        assertionNoteMatch(NOTE_1,result.get(0));
        assertionNoteMatch(NOTE_2,result.get(1));
    }

    @Test
    public void getNoteById_given_valid_id_return_note(){

        Note retreivedNote = sut.getNoteById(NOTE_1.getId());

        assertNotNull(retreivedNote, "getNoteById with valid id passed returned null");
        assertionNoteMatch(NOTE_1,retreivedNote);
    }

    @Test
    public void getNoteById_given_invalid_id_return_null(){

        Note retreivedNote = sut.getNoteById(0);

        assertNull(retreivedNote, "getNoteById with invalid id passed returned note");
    }

    @Test
    public void createNote_given_valid_note_return_createdNote(){
        Note testNote = new Note("test1","test note",false);

        Note createdNote = sut.createNote(testNote);
        assertNotNull(createdNote,"createNote returned null");

        testNote.setId(createdNote.getId());
        assertionNoteMatch(testNote,createdNote);
    }

    @Test
    public void updateNote_given_valid_id_return_updated_note(){
        NOTE_1.setTitle("test1");

        Note updatedNote = sut.updateNote(NOTE_1.getId(), NOTE_1);
        assertNotNull(updatedNote,"updateNote() return null");
        assertionNoteMatch(NOTE_1, updatedNote);
    }

    @Test
    public void updateNote_given_invalid_id_should_throw_exception(){
        NOTE_1.setTitle("test1");
        assertThrows(DaoException.class,()->sut.updateNote(0, NOTE_1),"Something went wrong, Unable to update the note");

    }

    @Test
    public void deleteNoteById_given_valid_id_return_number_od_row_updated(){

        int numberOfRowUpdated = sut.deleteNoteById(NOTE_1.getId());
        assertEquals(1,numberOfRowUpdated,"deleteNoteById() returned incorrect number of row updated");
    }

    @Test
    public void deleteNoteById_given_invalid_id_throw_exception(){

      assertThrows(DaoException.class,()->sut.deleteNoteById(0),"Something went wrong, Unable to update the note");
    }



    public void assertionNoteMatch(Note expected, Note actual){

        assertEquals(expected.getId(), actual.getId(),"Id doesn't match");
        assertEquals(expected.getTitle(), actual.getTitle(),"Title doesn't match");
        assertEquals(expected.getNote(), actual.getNote(),"Note doesn't match");
    }
}
