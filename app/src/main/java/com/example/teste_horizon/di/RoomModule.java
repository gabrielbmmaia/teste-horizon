package com.example.teste_horizon.di;

import static com.example.teste_horizon.core.Constantes.PACIENTE_DATABASE;

import android.app.Application;
import androidx.room.Room;
import com.example.teste_horizon.data.local.PacienteDao;
import com.example.teste_horizon.data.local.PacienteDatabase;
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
        return Room.databaseBuilder(application, PacienteDatabase.class, PACIENTE_DATABASE)
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
