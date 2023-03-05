package com.example.teste_horizon.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.teste_horizon.data.model.Paciente;

@Database(entities = {Paciente.class}, version = 1)
public abstract class PacienteDatabase extends RoomDatabase {

    public static final String PACIENTE_DATABASE = "paciente_db";

    public abstract PacienteDao pacienteDao();
}
