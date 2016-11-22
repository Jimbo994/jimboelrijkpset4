package com.example.jim.jimboelrijkpset4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> To_Do_List;
    ListView List;
    EditText to_be_added;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List = (ListView) findViewById(R.id.list);
        To_Do_List = new ArrayList<>();
        to_be_added = (EditText) findViewById(R.id.add_text);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, To_Do_List);

        // Connect the ListView with the Adapter that acts as a bridge between it and the array
        List.setAdapter(arrayAdapter);
    }

    public void add(View view) {

        if (!(to_be_added.length() == 0)){
            String add = to_be_added.getText().toString();
            To_Do_List.add(add);
            Toast.makeText(getApplicationContext(), "Added to to-do list!",Toast.LENGTH_LONG).show();
            List.setAdapter(arrayAdapter);
        }
        else{
            Toast.makeText(getApplicationContext(), "Please enter", Toast.LENGTH_LONG).show();
        }
    }
}
