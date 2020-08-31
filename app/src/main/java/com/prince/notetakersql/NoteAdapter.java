
package com.prince.notetakersql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prince.notetakersql.DB.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    public List<Note> notes;
    Context context;
    NoteAdapter(List<Note> notes,Context context){
        this.notes=notes;
        this.context=context;

    }

    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view= LayoutInflater.from(context).inflate(R.layout.layout_note,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder,int position){
        holder.note.setText(notes.get(position).getContent());

    }
    @Override
    public int getItemCount(){
        return notes.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView note;
        public ViewHolder(@NonNull View itemview){
            super(itemview);
            note=itemview.findViewById(R.id.note);
        }
    }

}
