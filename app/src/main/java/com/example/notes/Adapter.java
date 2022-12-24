package com.example.notes;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.*;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

   LayoutInflater inflater;
   List<NoteModel> noteModels;

   Adapter(Context context, List<NoteModel> noteModels){
       this.inflater=LayoutInflater.from(context);
       this.noteModels=noteModels;
   }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.note_view, parent, false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
       String title=noteModels.get(position).getNoteTitle();
       String date=noteModels.get(position).getNoteDate();
       String time=noteModels.get(position).getNoteTime();

       holder.nTitle.setText(title);
       holder.nDate.setText(date);
       holder.nTime.setText(time);

    }

    @Override
    public int getItemCount() {
        return noteModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nTitle, nDate, nTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nTitle=itemView.findViewById(R.id.nTitle);
            nTime=itemView.findViewById(R.id.nTime);
            nDate=itemView.findViewById(R.id.nDate);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Toast.makeText(itemView.getContext(),"Item Clicked", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
