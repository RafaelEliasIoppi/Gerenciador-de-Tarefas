package com.example.gerenciador_de_tarefas.testmodel;

// Fixture class used in tests. The real JPA entity lives under src/main.
public class TarefaFixture {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    public TarefaFixture() {
    }

    public TarefaFixture(boolean concluida, String descricao, Long id, String titulo) {
        this.concluida = concluida;
        this.descricao = descricao;
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
