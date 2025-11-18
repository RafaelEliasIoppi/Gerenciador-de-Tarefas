package com.example.gerenciador_de_tarefas.service;

import com.example.gerenciador_de_tarefas.model.Tarefa;
import com.example.gerenciador_de_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repo;

    public TarefaService(TarefaRepository repo) {
        this.repo = repo;
    }

    public List<Tarefa> listar() {
        return repo.findAll();
    }

    public Tarefa adicionar(String descricao, LocalDate prazo, String prioridade) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }
        Tarefa t = new Tarefa(null, descricao.trim(), false);
        t.setPrazo(prazo);
        t.setPrioridade(prioridade);
        return repo.save(t);
    }

    public Tarefa toggle(Long id) {
        var tarefa = repo.findById(id).orElseThrow();
        tarefa.setConcluida(!tarefa.isConcluida());
        return repo.save(tarefa);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
