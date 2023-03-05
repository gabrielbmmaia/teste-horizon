package com.example.teste_horizon.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PacienteDao {

    @Insert
    void insertAll(PacienteDto... pacienteDtos);

    @Query("SELECT * FROM pacienteDto")
    List<PacienteDto> getAllPacientes();

}
