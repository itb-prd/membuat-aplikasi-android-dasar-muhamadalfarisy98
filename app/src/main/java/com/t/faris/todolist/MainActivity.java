package com.t.faris.todolist;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> t = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getNewNameIntent = new Intent(view.getContext(), add.class);
                final int result = 2;

                startActivityForResult(getNewNameIntent, result);
            }
        });
        disp(); // Show the To Do in ListView
    }

    protected void disp() {

        ListAdapter y =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,t);
        ListView bebas =(ListView) findViewById(R.id.list);
        bebas.setAdapter(y);

        bebas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DialogFragment newFragment = edit.newInstance(i,t.get(i));
                newFragment.show(getFragmentManager(),"dialog");

            }
        }) ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && data != null) {
            // Edit a Task
            int index = data.getExtras().getInt("Index of ToDoList");

            String newToDo =data.getExtras().getString("New Name");
            t.set(index, newToDo);

        } else if (requestCode == 2 && data != null) {
            // Add a new Task
            String newToDo = data.getExtras().getString("New Name");
            t.add(newToDo);

        } else if (requestCode == 3 && data != null) {
            //delete a Task
            t.remove(data.getExtras().getInt("Index of ToDoList"));
        }
        disp(); // update ListView


    }
}
