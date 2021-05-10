package com.example.parcial2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Registro.class},version = 1)
public abstract class AppBaseGas extends RoomDatabase {

    public abstract RegistroDao registroDao();
}
