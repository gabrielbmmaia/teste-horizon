package com.example.teste_horizon.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PacienteDto.class}, version = 1)
public abstract class PacienteDatabase extends RoomDatabase {

    public static final String PACIENTE_DATABASE = "paciente_db";

    public abstract PacienteDao pacienteDao();
}
