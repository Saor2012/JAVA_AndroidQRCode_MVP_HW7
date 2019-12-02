package com.example.androidqrcodejava.data.room;

/*import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;*/

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;

import java.util.Objects;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "entry",primaryKeys = {"lName"})
public class Entry {
    @NonNull
    private String name;
    private String link;
    private long id;
    private Bitmap bitmap;

    @Ignore
    public Entry() {
    }
    /*
    * public Entry(@NonNull String lName, String FName) {
        this.lName = lName;
        this.FName = FName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "lName='" + lName + '\'' +
                ", FName='" + FName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return lName.equals(entry.lName) &&
                Objects.equals(FName, entry.FName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lName, FName);
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }
    * */

    public Entry(long id, String name, String link, Bitmap bitmap) {
        this.name = name;
        this.link = link;
        this.id = id;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id &&
                Objects.equals(name, entry.name) &&
                Objects.equals(link, entry.link) &&
                Objects.equals(bitmap, entry.bitmap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link, id, bitmap);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}