package com.prince.notetakersql.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int note_id;
    @ColumnInfo(name="content")
    private String content;

    public Note(int note_id,String content) {
        this.note_id = note_id;
        this.content=content;
    }

    public int getNote_id() {
        return note_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;

    }
}
