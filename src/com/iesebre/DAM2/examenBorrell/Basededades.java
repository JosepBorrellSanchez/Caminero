package com.iesebre.DAM2.examenBorrell;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

@SuppressLint("NewApi")
public class Basededades extends SQLiteOpenHelper {
	
	 //String sqlCreate = "CREATE TABLE Usuaris (codi INTEGER AUTO INCREMENT, nombreusuario TEXT, password TEXT, posicion TEXT)";

	public Basededades(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public Basededades(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS Usuaris");
		db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);

	}
	
	public Cursor llistarUsuaris(){
		 SQLiteDatabase db = getReadableDatabase();
		  
		 return db.rawQuery("SELECT ID AS _id, USERNAME AS name, POSITIONS FROM Usuaris;", null);  
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
