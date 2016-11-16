package com.t.faris.todolist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.EditText;

/**
 * Created by YA_ on 11/13/2016.
 */

public class add extends AppCompatActivity {
    Intent lastIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.addlayout);

        lastIntent = getIntent();

    }

    public void onSendNewTaskName(View view) {

        EditText newNameET = (EditText) findViewById(R.id.kata);
        String newName = String.valueOf(newNameET.getText());

        Intent goBack = new Intent();
        goBack.putExtra("New Name",newName);
        setResult(RESULT_OK, goBack);

        finish();
    }
}
