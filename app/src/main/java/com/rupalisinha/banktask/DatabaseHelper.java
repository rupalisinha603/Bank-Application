package com.rupalisinha.banktask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
        private String TABLE_NAME = "user_table";
        private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
            super(context, "User.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
            db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
            db.execSQL("insert into user_table values(9234567890,'Aman Singh',9000.00,'amansinha@gmail.com','XXXXXXXXXXXX1231','CNR09876541')");
            db.execSQL("insert into user_table values(8709826634,'Muskan Sinha',15822.67,'muskan68@gmail.com','XXXXXXXXXXXX2342','PNJ98765438')");
            db.execSQL("insert into user_table values(8456789122,'Abhishek Thakur',1359.56,'abhishek45@gmail.com','XXXXXXXXXXXX3417','CBRB87654325')");
            db.execSQL("insert into user_table values(6567890123,'Rupali Sinha',1500.01,'rupalisinha90@gmail.com','XXXXXXXXXXXX4124','AXS76543213')");
            db.execSQL("insert into user_table values(9878901234,'Saurav Singh',263.48,'sauravskp123@gmail.com','XXXXXXXXXXXX2342','BRO65432108')");
            db.execSQL("insert into user_table values(7789012345,'Neelam Patidar',945.16,'neelam.p@gmail.com','XXXXXXXXXXXX3459','CAB54321099')");
            db.execSQL("insert into user_table values(8890123456,'Pranit Kumar',5900.00,'pranitkumar786@gmail.com','XXXXXXXXXXXX4525','NSI43210984')");
            db.execSQL("insert into user_table values(9901234567,'Ayush Gupta',1805.22,'ayush2001@gmail.com','XXXXXXXXXXXX5232','ICI32109879')");
            db.execSQL("insert into user_table values(7812345678,'Shubham Sharma',1398.46,'shubham123@gmail.com','XXXXXXXXXXXX3458','AXD21098766')");
            db.execSQL("insert into user_table values(9134567809,'Nikhil Singh',1273.90,'nikhilsingh@gmail.com','XXXXXXXXXXXX4560','SBI10987650')");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
            onCreate(db);
        }

        public Cursor readalldata(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from user_table", null);
            return cursor;
        }

        public Cursor readparticulardata(String phonenumber){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
            return cursor;
        }

        public Cursor readselectuserdata(String phonenumber) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
            return cursor;
        }

        public void updateAmount(String phonenumber, String amount){
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
        }

        public Cursor readtransferdata(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("select * from transfers_table", null);
            return cursor;
        }

        public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("DATE", date);
            contentValues.put("FROMNAME", from_name);
            contentValues.put("TONAME", to_name);
            contentValues.put("AMOUNT", amount);
            contentValues.put("STATUS", status);
            Long result = db.insert(TABLE_NAME1, null, contentValues);
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }
    }

