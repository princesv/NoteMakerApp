package com.prince.notetakersql.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;



@Dao
public interface NoteDao {
    @Query("SELECT*FROM note")
    public  List<Note> getAll();

    @Insert
   public void insertNote(Note note);

    @Update
   public void updateNote(Note note);
    @Delete
   public void deleteNote(Note note);



}

