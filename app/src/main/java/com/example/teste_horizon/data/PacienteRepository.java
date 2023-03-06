package com.example.teste_horizon.data;

import static com.example.teste_horizon.core.Constantes.LIBERADO;
import static com.example.teste_horizon.core.Constantes.QUARENTENA;
import static com.example.teste_horizon.core.Constantes.TRATAMENTO;

import com.example.teste_horizon.data.local.PacienteDao;
import com.example.teste_horizon.data.model.Paciente;

import java.util.List;

public class PacienteRepository {

    private PacienteDao pacienteDao;

    public PacienteRepository(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public List<Paciente> getAllPacientes() {
        return pacienteDao.getAllPacientes();
    }

    public void addPaciente(Paciente paciente) {
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
            }
        } else {
            paciente.resultado = LIBERADO;
            pacienteDao.insertAll(paciente);
        }
    }
}
