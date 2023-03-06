package com.example.teste_horizon.di;

import com.example.teste_horizon.data.PacienteRepository;
import com.example.teste_horizon.data.PacienteRepositoryImpl;
import com.example.teste_horizon.data.local.PacienteDao;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {

    @Provides
    @Singleton
    public static PacienteRepository providesRepository(PacienteDao pacienteDao) {
        return new PacienteRepositoryImpl(pacienteDao);
    }

}
