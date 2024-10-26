package com.example.Front_END_TCC.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;

@Controller
public class FreelancerProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/perfil/freelancer/{id}")
    public String verPerfilFreelancer(@PathVariable Long id, Model model) {
        UserProfileEntity freelancer = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Freelancer não encontrado: " + id));
        model.addAttribute("freelancer", freelancer);
        return "perfil-freelancer";
    }
}
