package com.example.Front_END_TCC.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;

import java.util.List;

@Controller
public class ClinteHomeController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/cliente/home")
    public String listarFreelancers(Model model) {
        List<UserProfileEntity> freelancers = userProfileRepository.findAll(); // Você pode filtrar apenas freelancers
        model.addAttribute("freelancers", freelancers);
        return "cliente-home";
    }
}
