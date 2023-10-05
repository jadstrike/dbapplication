package com.example.dbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    EditText searchKey;
    Button btnSearch;
    DBHelper dbHelper;
    TextView searchUserView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchKey = findViewById(R.id.searchKey);
        btnSearch = findViewById(R.id.btnSearch);
        dbHelper= new DBHelper( this);
        searchUserView = findViewById(R.id.searchUserView);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUserName();
            }
        });
    }// end of create

    private void searchUserName() {
        String key = searchKey.getText().toString();
       ArrayList<String> searchUserArray = dbHelper.getUser(key);
       if(searchUserArray.size()==0){
           searchUserView.setText("No User Found !");


       }
       else {
           String user="";
           for (int i = 0; i < searchUserArray.size() ; i++) {
               user += searchUserArray.get(i)+ "\n";


           }
           searchUserView.setText(user);

       }



    }
}