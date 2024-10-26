package com.example.Front_END_TCC.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class EditFreelancerController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/editar-freelancer/{id}")
    public String mostrarFormularioEditarFreelancer(@PathVariable Long id, Model model) {
        UserProfileEntity freelancer = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Freelancer não encontrado: " + id));
        model.addAttribute("freelancer", freelancer);
        return "editar-freelancer";
    }

    @PostMapping("/editar-freelancer/{id}")
    public String editarFreelancer(@PathVariable Long id, @ModelAttribute UserProfileEntity freelancerAtualizado) {
        UserProfileEntity freelancer = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Freelancer não encontrado: " + id));

        // Atualiza os dados do freelancer
        freelancer.setNome(freelancerAtualizado.getNome());
        freelancer.setDescricaoServico(freelancerAtualizado.getDescricaoServico());
        freelancer.setLocalizacao(freelancerAtualizado.getLocalizacao());
        freelancer.setHabilidades(freelancerAtualizado.getHabilidades());

        userProfileRepository.save(freelancer); // Salva as alterações no banco de dados
        return "redirect:/perfil/freelancer/" + id; // Redireciona para o perfil do freelancer
    }
}
