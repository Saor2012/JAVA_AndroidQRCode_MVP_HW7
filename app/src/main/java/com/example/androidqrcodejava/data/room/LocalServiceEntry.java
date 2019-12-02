package com.example.androidqrcodejava.data.room;

/*import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;*/

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface LocalServiceEntry {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListEntry(List<Entry> list);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEntry(Entry entry);

    @Query("select * from entry")
    Flowable<List<Entry>> queryEntryList();

    @Query("SELECT * FROM entry WHERE id IS :id")
    Single<Entry> queryEntry(long id);
}

