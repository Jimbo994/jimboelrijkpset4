
package com.example.jim.jimboelrijkpset4;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class DB_Helper extends SQLiteOpenHelper {


    // set fields of database scheme
    private static final String DATABASE_NAME = "myDB.db";
    private static final int DATABASE_VERSION = 1;
    static final String TABLE = "ToDO";

    static String task = "task";
    private static final String _ID = "_id";



    // constructor
    DB_Helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    // on create
    @Override
    public void onCreate (SQLiteDatabase sqLitedatabase){
        String CREATE_TABLE = "CREATE TABLE " + TABLE + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + task + " TEXT);";
        sqLitedatabase.execSQL(CREATE_TABLE);

//        String createTable = "CREATE TABLE " + TaskContract.TaskEntry.TABLE + " ( " +
//                TaskContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                TaskContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

    }

//on upgrade

    @Override
    public void onUpgrade(SQLiteDatabase sqLitedatabase, int i, int i1) {
        sqLitedatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLitedatabase);
    }

//crud methods






}
