package com.example.teste_horizon.data;

import static com.example.teste_horizon.core.Constantes.LIBERADO;
import static com.example.teste_horizon.core.Constantes.QUARENTENA;
import static com.example.teste_horizon.core.Constantes.TRATAMENTO;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.teste_horizon.data.local.PacienteDao;
import com.example.teste_horizon.data.model.Paciente;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class PacienteRepositoryImpl implements PacienteRepository {

    private final PacienteDao pacienteDao;

    @Inject
    public PacienteRepositoryImpl(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public List<Paciente> getAllPacientes() {
        return pacienteDao.getAllPacientes();
    }

    public List<Paciente> filtrarLista(String string) {
        return pacienteDao.filtrar(string);
    }

    public void addPaciente(Paciente paciente) {
        Paciente pacienteExistente = pacienteDao.pesquisarPaciente(paciente.nome);

        if (!paciente.equals(pacienteExistente)) {
            if (paciente.viagem) {
                if (paciente.periodoTosse > 5 &&
                        paciente.periodoCefaleia > 5 &&
                        paciente.temperatura > 37) {

                    paciente.resultado = TRATAMENTO;
                    pacienteDao.insertAll(paciente);

                } else {
                    paciente.resultado = QUARENTENA;
                    pacienteDao.insertAll(paciente);

                }
            } else if (paciente.idade >= 10 &&
                    paciente.idade <= 60 &&
                    paciente.temperatura > 37 &&
                    paciente.periodoTosse > 5 &&
                    paciente.periodoCefaleia > 5) {

                paciente.resultado = QUARENTENA;
                pacienteDao.insertAll(paciente);


            } else if (paciente.idade > 60 ||
                    paciente.idade < 10) {

                if (paciente.temperatura > 37 ||
                        paciente.periodoCefaleia > 3 ||
                        paciente.periodoTosse > 5) {

                    paciente.resultado = QUARENTENA;
                    pacienteDao.insertAll(paciente);

                } else {
                    paciente.resultado = LIBERADO;
                    pacienteDao.insertAll(paciente);
                }
            } else {
                paciente.resultado = LIBERADO;
                pacienteDao.insertAll(paciente);
            }
        }
    }
}
