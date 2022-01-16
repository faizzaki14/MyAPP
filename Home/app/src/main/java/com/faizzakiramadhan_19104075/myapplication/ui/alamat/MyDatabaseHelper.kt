package com.faizzakiramadhan_19104075.myapplication.ui.alamat

import android.database.sqlite.SQLiteOpenHelper
import com.faizzakiramadhan_19104075.myapplication.ui.alamat.MyDatabaseHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.Toast

class MyDatabaseHelper internal constructor(private val context: Context?) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KATEGORI + " TEXT, " +
                COLUMN_ALAMAT + " TEXT, " +
                COLUMN_PAGES + " INTEGER);"
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, il: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addAlamat(kategori: String?, alamat: String?, pages: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_KATEGORI, kategori)
        cv.put(COLUMN_ALAMAT, alamat)
        cv.put(COLUMN_PAGES, pages)
        val result = db.insert(TABLE_NAME, null, cv)
        if (result == -1L) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Added Succesfully!", Toast.LENGTH_SHORT).show()
        }
    }

    fun readAllData(): Cursor? {
        val query = "SELECT * FROM " + TABLE_NAME
        val db = this.readableDatabase
        var cursor: Cursor? = null
        if (db != null) {
            cursor = db.rawQuery(query, null)
        }
        return cursor
    }

    fun updateData(row_id: String, kategori: String?, alamat: String?, pages: String?) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COLUMN_KATEGORI, kategori)
        cv.put(COLUMN_ALAMAT, alamat)
        cv.put(COLUMN_PAGES, pages)
        val result = db.update(TABLE_NAME, cv, " _id=?", arrayOf(row_id)).toLong()
        if (result != -1L) {
            Toast.makeText(context, "Succesfully Update", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteOneRow(row_id: String) {
        val db = this.writableDatabase
        val result = db.delete(TABLE_NAME, "_id=?", arrayOf(row_id)).toLong()
        if (result == -1L) {
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val DATABASE_NAME = "Alamat.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "alamat_user"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_KATEGORI = "kategori_alamat"
        private const val COLUMN_ALAMAT = "alamat"
        private const val COLUMN_PAGES = "pages"
    }
}