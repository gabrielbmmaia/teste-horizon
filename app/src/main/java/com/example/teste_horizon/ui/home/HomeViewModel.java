package com.example.teste_horizon.ui.home;

import androidx.lifecycle.ViewModel;

import com.example.teste_horizon.data.PacienteRepository;
import com.example.teste_horizon.data.model.Paciente;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    PacienteRepository repository;

    @Inject
    HomeViewModel(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> getPacientes() {
        return repository.getAllPacientes();
    }

    public List<Paciente> filtrarLista(String string) {
        return repository.filtrarLista(string);
    }
}
