package com.example.androidqrcodejava.data.room;

/*import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;*/

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entry.class,Entry.class}, version =2,exportSchema = false)
public abstract class PersonDataBase extends RoomDatabase {
    public abstract LocalServiceEntry getPaxDao();
}
