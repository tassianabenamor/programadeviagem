package org.example.models;

public class Rotas {
    private int id;
    private String descricao;

    // Construtor padrão
    public Rotas() {
    }

    // Construtor com todos os atributos
    public Rotas(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método toString
    @Override
    public String toString() {
        return "Rotas{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
