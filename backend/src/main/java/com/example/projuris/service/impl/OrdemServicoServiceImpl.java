package com.example.projuris.service.impl;

import com.example.projuris.model.Cliente;
import com.example.projuris.model.OrdemServico;
import com.example.projuris.repository.OrdemServicoRepository;
import com.example.projuris.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public Optional<OrdemServico> findById(Integer id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    public List<Optional<OrdemServico>> findByFuncionarioId(Integer id) {
        List<Optional<OrdemServico>> lista = ordemServicoRepository.findByFuncionarioId(id);
        return lista;
    }

    @Override
    public OrdemServico insert(OrdemServico ordemServico) {
        ordemServico.setDataCriacao(LocalDateTime.now());
        ordemServico.setIsPendente(true);
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public OrdemServico update(OrdemServico ordemServico) {
        Optional<OrdemServico> optionalOrdemServico = findById(ordemServico.getId());

        if (optionalOrdemServico.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        optionalOrdemServico.get().setId(ordemServico.getId());
        return ordemServicoRepository.save(optionalOrdemServico.get());
    }


    @Override
    public OrdemServico inicioServico(OrdemServico ordemServico) {
        Optional<OrdemServico> optionalOrdemServico = findById(ordemServico.getId());

        System.out.println("optional Ordem Servico: "+optionalOrdemServico);

        if (optionalOrdemServico.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        optionalOrdemServico.get().setDataInicioServico(LocalDateTime.now());
        optionalOrdemServico.get().setId(ordemServico.getId());
        return ordemServicoRepository.save(optionalOrdemServico.get());

    }



}
