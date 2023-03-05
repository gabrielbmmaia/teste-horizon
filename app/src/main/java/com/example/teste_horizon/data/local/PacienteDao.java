package com.example.teste_horizon.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.teste_horizon.data.model.Paciente;

import java.util.List;

@Dao
public interface PacienteDao {

    @Insert
    void insertAll(Paciente... pacienteDtos);

    @Query("SELECT * FROM Paciente")
    List<Paciente> getAllPacientes();

}
