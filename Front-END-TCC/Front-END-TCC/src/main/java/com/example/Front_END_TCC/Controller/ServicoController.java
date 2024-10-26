package com.example.Front_END_TCC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Front_END_TCC.Model.Servico;
import com.example.Front_END_TCC.service.ServicoService;

import java.util.List;

@Controller
@RequestMapping("/cliente/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping("/{clienteId}")
    public String listarServicos(@PathVariable Long clienteId, Model model) {
        List<Servico> servicos = servicoService.listarServicosPorCliente(clienteId);
        model.addAttribute("servicos", servicos);
        model.addAttribute("clienteId", clienteId);
        return "servicos-cliente"; // Nome do arquivo HTML para exibir serviços do cliente
    }

    @GetMapping("/novo/{clienteId}")
    public String exibirFormularioNovoServico(@PathVariable Long clienteId, Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("clienteId", clienteId);
        return "novo-servico";
    }

    @PostMapping("/salvar")
    public String salvarServico(@ModelAttribute Servico servico, @RequestParam("clienteId") Long clienteId) {
        servico.setClienteId(clienteId);
        servicoService.salvarServico(servico);
        return "redirect:/cliente/servicos/" + clienteId;
    }

    @GetMapping("/editar/{id}")
    public String editarServico(@PathVariable Long id, Model model) {
        Servico servico = servicoService.listarServicosPorCliente(id).stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado: " + id));
        model.addAttribute("servico", servico);
        return "editar-servico";
    }

    @PostMapping("/deletar/{id}")
    public String deletarServico(@PathVariable Long id, @RequestParam("clienteId") Long clienteId) {
        servicoService.deletarServico(id);
        return "redirect:/cliente/servicos/" + clienteId;
    }
}
