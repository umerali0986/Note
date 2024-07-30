package com.umerscode.Notes.Models;


import lombok.Getter;
import lombok.Setter;


public class Note {

    //Properties
    private int id;
    private String title;
    private String note;
    private boolean favorite;

    // Constructors
    public Note() {}

    public Note(String title, String note, boolean favorite) {
        this.title = title;
        this.note = note;
        this.favorite = favorite;
    }

    public Note(int id, String title, String note, boolean favorite) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.favorite = favorite;
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
