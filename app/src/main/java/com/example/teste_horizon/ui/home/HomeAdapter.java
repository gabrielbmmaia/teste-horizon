package com.example.teste_horizon.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste_horizon.data.model.Paciente;
import com.example.teste_horizon.databinding.ViewholderPatientBinding;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<Paciente> pacientes;

    public void setPacientesList(List<Paciente> pacientesList) {
        this.pacientes = pacientesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ViewholderPatientBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Paciente paciente = pacientes.get(position);
        holder.vincular(paciente);
    }

    @Override
    public int getItemCount() {
        return pacientes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private ViewholderPatientBinding binding;

        public MyViewHolder(ViewholderPatientBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void vincular(Paciente paciente) {
            binding.nomePaciente.setText(paciente.nome);
            binding.resultadoPaciente.setText(paciente.resultado);
        }
    }
}
