package com.t.faris.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by user on 11/13/2016.
 */

public class delete extends AppCompatActivity{
    Intent lastIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lastIntent = getIntent();

        int index = lastIntent.getExtras().getInt("Index of ToDoList");

        Intent goBack = new Intent();
        goBack.putExtra("Index of ToDoList",index);
        setResult(RESULT_OK, goBack);

        finish();
    }
}
