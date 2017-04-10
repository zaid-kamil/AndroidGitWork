package trainedge.sqlitedatabaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CISE on 08/04/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String CREATE_TABLE_MOVIES = "create table movies " +
            "( _id integer primary key autoincrement," +
            " name text not null," +
            "rating integer not null," +
            "year integer, )";

    public DBHelper(Context context) {
        super(context, "myDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST movies");
        onCreate(db);
    }
}
