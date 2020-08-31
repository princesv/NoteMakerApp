package com.prince.notetakersql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.prince.notetakersql.DB.Note;
import com.prince.notetakersql.DB.NoteDB;
import com.prince.notetakersql.DB.NoteDao;

public class MainActivity extends AppCompatActivity {
      EditText todofield;
      Button add;
      RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todofield=findViewById(R.id.editText);
        add=findViewById(R.id.button);
        recyclerView=findViewById(R.id.recyclerView);
        final NoteDao dao=NoteDB.getInstance(this).getNoteDao();
        final NoteAdapter adapter=new NoteAdapter(dao.getAll(),this);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todoText= todofield.getText().toString();
                if(!todoText.isEmpty()){
                    dao.insertNote(new Note(0,todoText));
                    todofield.setText("");
                    adapter.notes=dao.getAll();
                    adapter.notifyDataSetChanged();
                }
            }
        });
        final ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                dao.deleteNote(dao.getAll().get(position));
                adapter.notifyDataSetChanged();


            }


        };
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
