package com.example.dbapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListUserActivity extends AppCompatActivity {
    ListView userListView;
    String[] user = {};
    DBHelper dbHelper;
    String[] from = new String[]{DBHelper.USER_ID, DBHelper.USER_NAME, DBHelper.USER_EMAIL};//attribute name
    int[] to = new int[]{R.id.textViewUserID,R.id.textViewUserName,R.id.textViewUserEmail}; //layout id name


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        userListView = findViewById(R.id.userListView);
        dbHelper = new DBHelper(this);
        Cursor cursor= dbHelper.fetchAllUsers();
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,R.layout.user_list_layout,cursor,from, to, 0);
        cursorAdapter.notifyDataSetChanged();


//        ArrayList<String> user_array = dbHelper.getAllUsers();
//
//
//        String[] user = user_array.toArray(new String[user_array.size()]);
//        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, user);
//        userListView.setTextFilterEnabled(true);
        userListView.setAdapter(cursorAdapter);
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), ""+user[position],Toast.LENGTH_SHORT).show();
                TextView textViewUserID = view.findViewById(R.id.textViewUserID);
                TextView textViewUserName = view.findViewById(R.id.textViewUserName);
                TextView textViewUserEmail = view.findViewById(R.id.textViewUserEmail);

                String user_id = textViewUserID.getText().toString();
                String name = textViewUserName.getText().toString();
                String email = textViewUserEmail.getText().toString();
//                String st = user_id + ":  "+ name+email;

//                Toast.makeText(getApplicationContext(), st, Toast.LENGTH_LONG).show();
                  Intent intent = new Intent(ListUserActivity.this,ModifyActivity.class);
                  intent.putExtra("id", user_id);
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        if (item.getItemId() == R.id.itemAdd) {
            Intent intent = new Intent(ListUserActivity.this, AddUserActivity.class);
            startActivity(intent);


            return true;
        } else if (item.getItemId() == R.id.itemSearch) {
            //Search


            return true;

        } else if (item.getItemId() == R.id.itemShow) {
            //Show



            return true;

        } else
            return super.onOptionsItemSelected(item);
    }
}
// With Listview = arrayadapter
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_user);
//
//        userListView = findViewById(R.id.userListView);
//        dbHelper = new DBHelper(this);
//        ArrayList<String> user_array = dbHelper.getAllUsers();
//
//
//        String[] user = user_array.toArray(new String[user_array.size()]);
//        ArrayAdapter<String> userArrayAdapter= new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, user);
//        userListView.setTextFilterEnabled(true);
//        userListView.setAdapter(userArrayAdapter);
//        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), ""+user[position],Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }