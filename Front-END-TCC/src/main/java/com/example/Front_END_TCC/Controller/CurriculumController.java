package com.example.Front_END_TCC.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Front_END_TCC.Model.Curriculum;
import com.example.Front_END_TCC.repository.CurriculumRepository;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CurriculumController {

    @Autowired
    private CurriculumRepository curriculumRepository;

    @GetMapping("/curriculo/{freelancerId}")
    public String verCurriculo(@PathVariable Long freelancerId, Model model) {
        Curriculum curriculum = curriculumRepository.findByFreelancerId(freelancerId);
        model.addAttribute("curriculum", curriculum);
        return "curriculo";
    }

    @GetMapping("/editar-curriculo/{freelancerId}")
    public String editarCurriculoForm(@PathVariable Long freelancerId, Model model) {
        Curriculum curriculum = curriculumRepository.findByFreelancerId(freelancerId);
        model.addAttribute("curriculum", curriculum);
        return "editar-curriculo";
    }

    @PostMapping("/editar-curriculo/{freelancerId}")
    public String salvarCurriculo(@PathVariable Long freelancerId, @ModelAttribute Curriculum curriculum) {
        curriculum.setFreelancerId(freelancerId);
        curriculumRepository.save(curriculum);
        return "redirect:/curriculo/" + freelancerId;
    }
}
