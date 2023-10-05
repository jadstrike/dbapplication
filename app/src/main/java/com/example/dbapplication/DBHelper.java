package com.example.dbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "my_db";
    public   static  final String USER_ID ="_id"; //cursor
    public static final String TABLE_NAME= "user";

    public   static final String USER_EMAIL = "email";
    public static final String USER_NAME = "name";

    private  SQLiteDatabase database;



    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        database= getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreate = "create table "+ TABLE_NAME +"("+ USER_ID+" integer primary key autoincrement,"+USER_NAME+
                " text,"+USER_EMAIL+" text)";
        db.execSQL(tableCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "drop table if exists " +TABLE_NAME;
        db.execSQL(dropTable);
        onCreate(db);

    } //onUpgrade


   // public long saveUser(String name, String email) {
   public long saveUser(User user) {
        //String name = "John Smith";
        //String email = "john123@gmail.com";
        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());//name
        values.put(USER_EMAIL,user.getEmail());//email

        long user_id = database.insertOrThrow(TABLE_NAME, null, values);





        return user_id ;
    }//end of saveUser

public ArrayList<String> getAllUsers() {
    database = getReadableDatabase();
   Cursor results = database.query(TABLE_NAME, new String[]{
            USER_ID, USER_NAME, USER_EMAIL
    },null, null, null, null, USER_NAME);
   results.moveToFirst();// first row(id, name, email)
   //int no_of_rows = results.getCount();
   ArrayList<String> user_array = new ArrayList<>();

    //for(int i=0; i<no_of_rows; i++){
   while (!results.isAfterLast()){
       int id = results.getInt(0);
       String name = results.getString(1);
       String email = results.getString(2);

       String record = id +": "+name+", "+email+", "+" ";
       user_array.add(record);

        results.moveToNext(); //next row
   }//end of for loop
    return  user_array;



}// end of getAllUsers
    public void deleteUser(int user_id){
//        int user_id = 2;
        //database.delete(TABLE_NAME, "", new String[]{});
        database.delete(TABLE_NAME, USER_ID+"=?", new String[]{String.valueOf(user_id)});


    }
    public  void updateUser(int user_id, String name, String email){
        ContentValues values = new ContentValues();
        values.put(USER_NAME, name);
        values.put(USER_EMAIL, email);

        database.update(TABLE_NAME, values, USER_ID+"=?", new String[]{String.valueOf(user_id)});
    }
    //Search User
    public ArrayList<String> getUser( String key) {
        database = getReadableDatabase();
        Cursor results = database.query(TABLE_NAME, new String[]{
                USER_ID, USER_NAME, USER_EMAIL
        },USER_NAME+" LIKE ? OR "+USER_EMAIL+" LIKE ?",new String[]{"%"+key+"%","%"+key+"%"}, null, null, null);
        results.moveToFirst();// first row(id, name, email)
        //int no_of_rows = results.getCount();
        ArrayList<String> user_array = new ArrayList<>();

        //for(int i=0; i<no_of_rows; i++){
        while (!results.isAfterLast()){
            int id = results.getInt(0);
            String name = results.getString(1);
            String email = results.getString(2);

            String record = id +": "+name+", "+email+", "+" ";
            user_array.add(record);

            results.moveToNext(); //next row
        }//end of for loop
        return  user_array;



    }// end of getUser

    public Cursor fetchAllUsers(){
         database = getReadableDatabase();
         String [] columns = new String[]{USER_ID, USER_NAME, USER_EMAIL};
         Cursor cursor = database.query(TABLE_NAME, columns,null, null, null, null, USER_NAME);

         if (cursor !=null) cursor.moveToFirst();

        return cursor;
    }


}//end of the class


