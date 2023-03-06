package com.example.teste_horizon.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Paciente {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nome;
    public int idade;
    public int temperatura;
    @ColumnInfo(name = "periodo_tosse")
    public int periodoTosse;
    @ColumnInfo(name = "periodo_cefaleia")
    public int periodoCefaleia;
    public boolean viagem;
    public String resultado;

    public Paciente(String nome, int idade, int temperatura, int periodoTosse, int periodoCefaleia, boolean viagem, String resultado) {
        this.nome = nome;
        this.idade = idade;
        this.temperatura = temperatura;
        this.periodoTosse = periodoTosse;
        this.periodoCefaleia = periodoCefaleia;
        this.viagem = viagem;
        this.resultado = resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return idade == paciente.idade && Objects.equals(nome, paciente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
