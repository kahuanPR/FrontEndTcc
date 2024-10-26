package com.example.Front_END_TCC.Controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;

	@Controller
	public class ClienteProfileController {

	    @Autowired
	    private UserProfileRepository userProfileRepository;

	    @GetMapping("/cliente/perfil/{id}")
	    public String visualizarPerfilCliente(@PathVariable Long id, Model model) {
	        UserProfileEntity cliente = userProfileRepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id));
	        model.addAttribute("cliente", cliente);
	        return "cliente-perfil";
	    }
	}
