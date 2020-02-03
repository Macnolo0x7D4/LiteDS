package me.macnolo.liteds.protocol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Logger {
    private LogHelper logDb;

    public Logger(Context context) {
        logDb = new LogHelper(context, LogConstants.DB_NAME, null, 1);
    }

    public Long regLog(String origin, String type, String log){
        SQLiteDatabase db = logDb.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LogConstants.ORIGIN, origin);
        values.put(LogConstants.TYPE, type);
        values.put(LogConstants.LOG, log);

        Long id = db.insert(LogConstants.TABLE, LogConstants.ID, values);
        db.close();

        return id;
    }


}
