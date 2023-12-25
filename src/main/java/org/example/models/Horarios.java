package org.example.models;

public class Horarios {
    private int id;
    private String diaDaSemana;
    private String horarioAbertura;
    private String horarioFechamento;

    // Construtor padrão
    public Horarios() {
    }

    // Construtor com todos os atributos
    public Horarios(int id, String diaDaSemana, String horarioAbertura, String horarioFechamento) {
        this.id = id;
        this.diaDaSemana = diaDaSemana;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(String horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    // Método toString
    @Override
    public String toString() {
        return "Horarios{" +
                "id=" + id +
                ", diaDaSemana='" + diaDaSemana + '\'' +
                ", horarioAbertura='" + horarioAbertura + '\'' +
                ", horarioFechamento='" + horarioFechamento + '\'' +
                '}';
    }
}
