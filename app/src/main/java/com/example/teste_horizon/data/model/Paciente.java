package com.example.teste_horizon.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
}
