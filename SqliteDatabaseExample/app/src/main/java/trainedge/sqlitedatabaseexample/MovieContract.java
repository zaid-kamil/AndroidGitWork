package trainedge.sqlitedatabaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

/**
 * Created by CISE on 08/04/2017.
 */

public class MovieContract {

    SQLiteDatabase database;
    Context context;
    DBHelper helper;

    /*fixed column name*/
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_RATING = "rating";
    public static final String COL_YEAR = "year";
    public static final String TABLE_MOVIES = "movies";


    public MovieContract(Context context) {
        this.context = context;
    }

    /*open database*/
    public void open() {
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
    }

    /*close database*/
    public void close() {

        database.close();
        helper = null;

    }

    /*new movie add*/
    public long addMovie(String name, int year, int rating) {
        ContentValues val = getContentValues(name, year, rating);
        return database.insert(TABLE_MOVIES, null, val);
    }

    @NonNull
    private ContentValues getContentValues(String name, int year, int rating) {
        ContentValues val = new ContentValues();
        val.put(COL_NAME, name);
        val.put(COL_YEAR, year);
        val.put(COL_RATING, rating);
        return val;
    }

    /*movie delete*/
    public int deleteMovie(long movieId) {

        String where = COL_ID + "=?";

        String[] whereArgs = new String[]{String.valueOf(movieId)};

        return database.delete(TABLE_MOVIES, where, whereArgs);

    }
    /*movie search by name*/

    public Cursor searchMovieByName(String movieName) {
        String where = COL_NAME + " = ?";
        String[] whereArgs = new String[]{movieName};
        return database.query(TABLE_MOVIES, null, where, whereArgs, null, null, null);
    }

    /*movie list*/
    public Cursor getAllMovies() {
        return database.query(TABLE_MOVIES, null, null, null, null, null, null);
    }
    /*movie edit*/

    public int updateMovieById(long movieId, String name, int rating, int year) {
        ContentValues values = getContentValues(name, year, rating);
        String where = COL_ID + "=?";
        String[] whereArgs = new String[]{String.valueOf(movieId)};
        return database.update(TABLE_MOVIES, values, where, whereArgs);
    }
}
