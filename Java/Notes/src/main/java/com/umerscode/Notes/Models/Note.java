package com.umerscode.Notes.Models;


import lombok.Getter;
import lombok.Setter;


public class Note {

    //Properties
    private int id;
    private String title;
    private String note;

    // Constructors
    public Note() {}

    public Note(String title, String note) {
        this.title = title;
        this.note = note;
    }

    public Note(int id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    // Getters & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
