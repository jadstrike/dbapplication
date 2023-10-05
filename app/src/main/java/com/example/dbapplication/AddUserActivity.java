package com.example.dbapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {
    EditText editName;
    EditText editEmail;
    Button   btnAddUser;

    DBHelper DBHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        btnAddUser = findViewById(R.id.btnAddUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();

            }
        });
    }//end of onCreate

    private void addUser() {
        DBHelper = new DBHelper(this);
      String name=  editName.getText().toString();
      String email = editEmail.getText().toString();


      User user = new User(name, email);
       //long user_id = DBHelper.saveUser(name, email);
        long user_id = DBHelper.saveUser(user);

        Toast.makeText(this, "User added "+user_id, Toast.LENGTH_SHORT).show();



    }
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        if (item.getItemId() == R.id.itemAdd) {
            Intent intent = new Intent(AddUserActivity.this, AddUserActivity.class);
            startActivity(intent);


            return true;
        } else if (item.getItemId() == R.id.itemSearch) {
            //Search


            return true;

        } else if (item.getItemId() == R.id.itemShow) {
            //Show
            Intent intent = new Intent(AddUserActivity.this, ListUserActivity.class);
            startActivity(intent);



            return true;

        } else
            return super.onOptionsItemSelected(item);
    }
}
//end of the class