package com.example.dbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

public class ModifyActivity extends AppCompatActivity {

    EditText modifyUserName;
    EditText modifyUserEmail;
    EditText modifyUserRemark;

    Button btnUpdate, btnDelete;
    String id, name, email;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        modifyUserName = findViewById(R.id.modifyUserName);
        modifyUserEmail = findViewById(R.id.modifyUserEmail);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        id = intent.getExtras().getString("id");
        name = intent.getExtras().getString("name");
        email = intent.getExtras().getString("email");
        modifyUserName.setText(name);
        modifyUserEmail.setText(email);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ModifyActivity.this);
                builder.setTitle("Confirm Delete");
                builder.setMessage("Are you sure you want to delete this user?");

                // Add positive button to confirm deletion
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User confirmed deletion, so delete the user and proceed
                        dbHelper.deleteUser(Integer.parseInt(id));
                        Intent listintent = new Intent(ModifyActivity.this, ListUserActivity.class);
                        startActivity(listintent);
                    }
                });

                // Add negative button to cancel deletion
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User canceled deletion, so do nothing
                        dialog.dismiss();
                    }
                });

                // Show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dbHelper.deleteUser(Integer.parseInt(id));
//                Intent listintent = new Intent(ModifyActivity.this, ListUserActivity.class);
//                startActivity(listintent);
//
//
//            }
//        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dbHelper.updateUser(Integer.parseInt(id), modifyUserName.getText().toString(), modifyUserEmail.getText().toString());
                Intent listintent = new Intent(ModifyActivity.this, ListUserActivity.class);
                startActivity(listintent);



            }
        });





    }//on create
}// class