package csc214.project3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by leew15 on 4/22/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "clothes_database.db";
    public static final String TABLE_NAME = "CLOTHES";
    public static final String TYPE = "type";
    public static final String COLOR = "color";
    public static final String BRAND = "brand";
    public static final String _ID = "_id";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME
                + "(_id integer primary key autoincrement, "
                + TYPE + ", "
                + COLOR + ", "
                + BRAND + ")");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addClothes(String type, String color, String brand){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TYPE, type);
        values.put(COLOR, color);
        values.put(BRAND, brand);

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='CLOTHES'");

        return db.delete(TABLE_NAME, "_id = ?", new String[] {id});
    }
    public String getType(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, "_id" + " =?", new String[]{_ID}, null, null, null);
        if (cursor.getCount() < 1){
            cursor.close();
            return "Does not exist";
        }
        cursor.moveToFirst();
        String type = cursor.getString(cursor.getColumnIndex(TYPE));
        System.out.println(type);

        cursor.close();
        return type;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);

        return cursor;
    }
    public int getClothingCount(){
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }
}
