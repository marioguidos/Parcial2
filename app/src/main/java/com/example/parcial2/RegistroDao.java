package com.example.parcial2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface RegistroDao {

    @Query("SELECT * FROM registro")
    List<Registro> getAll();

    @Query("SELECT *FROM REGISTRO WHERE idFactura=:facturaid")
    List<Registro> buscarRegistro (int facturaid);

    @Insert
    Long insert(Registro registro);


}
