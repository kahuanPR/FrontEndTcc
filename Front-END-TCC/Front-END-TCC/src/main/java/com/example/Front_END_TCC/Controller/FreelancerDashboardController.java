package com.example.Front_END_TCC.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Front_END_TCC.Model.Servico;
import com.example.Front_END_TCC.repository.ServicoRepository;

import java.util.List;

@Controller
public class FreelancerDashboardController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/freelancer-dashboard")
    public String listarServicosDisponiveis(Model model) {
        List<Servico> servicos = servicoRepository.findAll();
        model.addAttribute("servicos", servicos);
        return "freelancer-dashboard";
    }
}
