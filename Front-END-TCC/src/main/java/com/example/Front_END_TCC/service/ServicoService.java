package com.example.Front_END_TCC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Front_END_TCC.Model.Servico;
import com.example.Front_END_TCC.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicosPorCliente(Long clienteId) {
        return servicoRepository.findByClienteId(clienteId);
    }

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }
}