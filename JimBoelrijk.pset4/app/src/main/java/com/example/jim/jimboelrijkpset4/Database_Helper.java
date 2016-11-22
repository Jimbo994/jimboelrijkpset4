package com.example.jim.jimboelrijkpset4;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jim on 22-11-2016.
 */

public class Database_Helper extends SQLiteOpenHelper{


// set fields of database scheme
        private static final String DATABASE_NAME = "myDB.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE = "contacts"

        String name_id = "name";
        String phone_id = "phone";


        // constructor
        public Database_Helper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);

        }

        // on create
        @Override
        public void onCreate (SQLiteDatabase sqLitedatabase){
            String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( _id INTEGER PRIMARY KEY AUTOINCREMENT, " + name_id + " TEXT, " + phone_id + " TEXT)";
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }

//on upgrade
        @Override
        public void on Upgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
            onCreate(sqLiteDatabase);
        }

//crud methods

        //create
        public void create(Person person){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(name_id, person.name);
            values.put(phone_id, perosn.phonenumber);
            db.insert(TABLE, null, values);
            db.close();
        }

        //read
        public ArrayList<HashmMap<String, String>> read(){
            SQLiteDatabase db = getReadableDatabase();
            String query = "SELECT _id , " + name_id + " , " + phone_id + " FROM " + TABLE ;
            ArrayList<HashmMap<String, String>> phonebook = new ArrayList<>();
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()){
                do {
                    Hashmap<String, String> persondata = new Hashmap<>();
                    persondata.put("id", cursor.getString(cursor.getColumIndex("_id"));
                    (zelfde verhaal voor telefoonnummer etc. (in het geval van to do list waarschijlnijk niet nodig)

                    phonebook.add(persondata);
                }
                while(cursor.moveToNext());

            }
            corsor.close();
            db.close();
            return phonebook;
        }
        //update
        public void update(Person person){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(phone_id, person.phonenumber)
            (dit okok voor andere dingen weer)
            db.update(TABLE, values, "_id = ? ", new String[] {String.valueOf(person.id)}
                    db.close();

        }

        //delete
        public void delete (int id){
            SQLiteDatabase db = getWritableDatabase();
            db.delete(TABLE, " _id = ?, new String[]{string.valueof(id)});
                    db.close()

        }

    }
