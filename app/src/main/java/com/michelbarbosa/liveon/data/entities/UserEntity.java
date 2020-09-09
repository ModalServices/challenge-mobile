package com.michelbarbosa.liveon.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pk_id")
    private int id;

    @ColumnInfo(name = "urlPictureAvatar")
    private String urlPictureAvatar;

    @ColumnInfo(name = "pk_username")
    private String username;

    @ColumnInfo(name = "fullname")
    private String fullname;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "uf")
    private String uf;

    public UserEntity(@NonNull int id, String urlPictureAvatar, String username, String fullname, String city, String uf) {
        this.id = id;
        this.urlPictureAvatar = urlPictureAvatar;
        this.username = username;
        this.fullname = fullname;
        this.city = city;
        this.uf = uf;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getUrlPictureAvatar() {
        return urlPictureAvatar;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }
}
