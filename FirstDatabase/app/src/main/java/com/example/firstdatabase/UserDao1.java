package com.example.firstdatabase;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao1 {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User users);
}
