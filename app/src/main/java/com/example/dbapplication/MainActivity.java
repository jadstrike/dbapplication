package com.example.dbapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*

    TextView textView;
    Button btnSave;

     */
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // dbHelper = new DBHelper(this);

    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (@NonNull MenuItem item){
            if (item.getItemId() == R.id.itemAdd) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);


                return true;
            } else if (item.getItemId() == R.id.itemSearch) {
                //Search
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                return true;


            } else if (item.getItemId() == R.id.itemShow) {
                //Show
                Intent intent = new Intent(MainActivity.this, ListUserActivity.class);
                startActivity(intent);


                return true;

            } else
                return super.onOptionsItemSelected(item);
        }
    /*

        textView = findViewById(R.id.textView);
        */

        /*
        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();

            }
        });
       String data = dbHelper.getAllUsers();
       textView.setText(data);
       dbHelper.deleteUser();
       dbHelper.updateUser();

    }//end of onCreate

    private void save() {
     // long user_id =  dbHelper.saveUser( "Aung Aung", "issac@gmail.com");
       // Toast.makeText(this, "Saved user ID: "+user_id,Toast.LENGTH_SHORT).show();



    }
}//end of class
*/
}