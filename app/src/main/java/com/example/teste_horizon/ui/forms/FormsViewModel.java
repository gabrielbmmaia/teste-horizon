package com.example.teste_horizon.ui.forms;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.teste_horizon.data.PacienteRepository;
import com.example.teste_horizon.data.PacienteRepositoryImpl;
import com.example.teste_horizon.data.model.Paciente;

import java.util.concurrent.ExecutorService;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FormsViewModel extends ViewModel {

    PacienteRepository repository;

    @Inject
    FormsViewModel(PacienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrarPaciente(Paciente paciente) {
        Log.e("Teste", "ViewModel: " + paciente);
        repository.addPaciente(paciente);
    }
}
