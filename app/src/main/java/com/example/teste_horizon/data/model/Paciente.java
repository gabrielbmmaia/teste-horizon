package com.example.teste_horizon.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Paciente {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nome = "";
    public int idade = 0;
    public double temperatura;
    @ColumnInfo(name = "periodo_tosse")
    public int periodoTosse;
    @ColumnInfo(name = "periodo_cefaleia")
    public int periodoCefaleia;
    public boolean viagem;
    public String resultado;

    public Paciente(String nome, int idade, double temperatura, int periodoTosse, int periodoCefaleia, boolean viagem) {
        this.nome = nome;
        this.idade = idade;
        this.temperatura = temperatura;
        this.periodoTosse = periodoTosse;
        this.periodoCefaleia = periodoCefaleia;
        this.viagem = viagem;
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

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", temperatura=" + temperatura +
                ", periodoTosse=" + periodoTosse +
                ", periodoCefaleia=" + periodoCefaleia +
                ", viagem=" + viagem +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
