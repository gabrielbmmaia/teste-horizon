package com.example.teste_horizon.data;

import androidx.lifecycle.LiveData;

import com.example.teste_horizon.data.model.Paciente;

import java.util.List;

public interface PacienteRepository {

    void addPaciente(Paciente paciente);

    List<Paciente> getAllPacientes();

    List<Paciente> filtrarLista(String string);
}
