package org.example.models;

import java.util.Date;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private Date dataEvento;
    private int localizacaoId; // ID da localização associada ao evento

    // Construtor padrão
    public Evento() {
    }

    // Construtor com todos os atributos
    public Evento(int id, String nome, String descricao, Date dataEvento, int localizacaoId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataEvento = dataEvento;
        this.localizacaoId = localizacaoId;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public int getLocalizacaoId() {
        return localizacaoId;
    }

    public void setLocalizacaoId(int localizacaoId) {
        this.localizacaoId = localizacaoId;
    }

    // Método toString
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataEvento=" + dataEvento +
                ", localizacaoId=" + localizacaoId +
                '}';
    }
}
