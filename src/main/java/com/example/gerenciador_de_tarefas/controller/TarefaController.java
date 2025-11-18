package com.example.gerenciador_de_tarefas.controller;

import com.example.gerenciador_de_tarefas.service.TarefaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        var tarefas = service.listar();
        model.addAttribute("tarefas", tarefas);
        model.addAttribute("total", tarefas.size());
        model.addAttribute("concluidas", tarefas.stream().filter(t -> t.isConcluida()).count());
        model.addAttribute("pendentes", tarefas.stream().filter(t -> !t.isConcluida()).count());
        return "tarefas";
    }

    @PostMapping
    public String adicionar(@RequestParam String descricao,
                            @RequestParam(required=false) LocalDate prazo,
                            @RequestParam(defaultValue="MEDIA") String prioridade,
                            RedirectAttributes redirectAttrs) {
        try {
            service.adicionar(descricao, prazo, prioridade);
            redirectAttrs.addFlashAttribute("sucesso", "Tarefa adicionada com sucesso!");
        } catch (IllegalArgumentException e) {
            redirectAttrs.addFlashAttribute("erro", e.getMessage());
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/{id}/toggle")
    public String toggle(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        service.toggle(id);
        redirectAttrs.addFlashAttribute("sucesso", "Status da tarefa atualizado!");
        return "redirect:/tarefas";
    }

    @PostMapping("/{id}/remover")
    public String remover(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        service.remover(id);
        redirectAttrs.addFlashAttribute("sucesso", "Tarefa removida!");
        return "redirect:/tarefas";
    }
}
