package com.example.projuris.service.impl;

import com.example.projuris.model.Cliente;
import com.example.projuris.model.OrdemServico;
import com.example.projuris.repository.OrdemServicoRepository;
import com.example.projuris.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
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
    public Optional<OrdemServico> iniciarServico(Integer id) {
        Optional<OrdemServico> optionalOrdemServico = findById(id);

        if (optionalOrdemServico.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        optionalOrdemServico.get().setDataInicioServico(LocalDateTime.now());
        optionalOrdemServico.get().setIsPendente(false);
        ordemServicoRepository.save(optionalOrdemServico.get());
        return optionalOrdemServico;
    }

    @Override
    public List<Optional<OrdemServico>>findServicosIniciadosFuncionarioId(Integer id){

        List<Optional<OrdemServico>> lista = ordemServicoRepository.findServicosIniciadosFuncionarioId(id);
        return lista;
    }

    @Override
    public Optional<OrdemServico> finalizarServico(Integer id) {
        Optional<OrdemServico> optionalOrdemServico = findById(id);

        if (optionalOrdemServico.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        optionalOrdemServico.get().setDataTerminoServico(LocalDateTime.now());
        ordemServicoRepository.save(optionalOrdemServico.get());
        return optionalOrdemServico;
    }

    @Override
    public List<Optional<OrdemServico>>findServicosFinalizadosFuncionarioId(Integer id){
        List<Optional<OrdemServico>> lista = ordemServicoRepository.findServicosFinalizadosFuncionarioId(id);
        return lista;
    }



}
