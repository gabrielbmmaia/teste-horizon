package com.example.teste_horizon.di;

import android.app.Application;

import androidx.room.Room;

import com.example.teste_horizon.data.PacienteDao;
import com.example.teste_horizon.data.PacienteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    @Provides
    @Singleton
    public static PacienteDatabase provideDB(Application application) {
        return Room.databaseBuilder(application, PacienteDatabase.class, PacienteDatabase.PACIENTE_DATABASE)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PacienteDao providePacienteDao(PacienteDatabase pacienteDatabase) {
        return pacienteDatabase.pacienteDao();
    }
}
