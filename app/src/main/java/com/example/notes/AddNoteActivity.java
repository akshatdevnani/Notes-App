package com.example.notes;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {

    EditText title, details;
    Button addNoteBtn;
    String todayDate, currentTime;
    Calendar calendar;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        getSupportActionBar().setTitle("Add New Note");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        title=findViewById(R.id.addNote);
        details=findViewById(R.id.noteDetails);
        addNoteBtn=findViewById(R.id.addNoteBtn);

        calendar=Calendar.getInstance();
        todayDate=calendar.get(Calendar.YEAR) + "/" +  calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH);
        currentTime=pad(calendar.get(Calendar.HOUR)) + ":" +  pad(calendar.get(Calendar.MINUTE));

        addNoteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view) {
                NoteModel noteModel = new NoteModel(title.getText().toString(), details.getText().toString(),todayDate, currentTime);
                NoteDatabase db = new NoteDatabase(AddNoteActivity.this);
                db.AddNote(noteModel);
            }
        });

    }
    public String pad(int i){
        if(i<0)
            return "0" + i;
        return String.valueOf(i);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}