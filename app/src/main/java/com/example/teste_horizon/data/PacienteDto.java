package com.example.teste_horizon.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PacienteDto {

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

    public PacienteDto(String nome, int idade, int temperatura, int periodoTosse, int periodoCefaleia, boolean viagem) {
        this.nome = nome;
        this.idade = idade;
        this.temperatura = temperatura;
        this.periodoTosse = periodoTosse;
        this.periodoCefaleia = periodoCefaleia;
        this.viagem = viagem;
    }
}
