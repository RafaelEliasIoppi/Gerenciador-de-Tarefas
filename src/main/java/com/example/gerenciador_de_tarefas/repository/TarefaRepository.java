package com.example.gerenciador_de_tarefas.repository;

import com.example.gerenciador_de_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}
