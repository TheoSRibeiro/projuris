package com.example.projuris.service.impl;

import com.example.projuris.model.AcompanhamentoOrdemServico;
import com.example.projuris.repository.AcompanhamentoOrdemServicoRepository;
import com.example.projuris.service.AcompanhamentoOrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AcompanhamentoOrdemServicoServiceImpl implements AcompanhamentoOrdemServicoService {

    @Autowired
    private AcompanhamentoOrdemServicoRepository repository;

    @Override
    public List<AcompanhamentoOrdemServico> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<AcompanhamentoOrdemServico> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public AcompanhamentoOrdemServico insert(AcompanhamentoOrdemServico acompanhamentoOrdemServico) {
        acompanhamentoOrdemServico.setDataCriacao(LocalDateTime.now());
        return repository.save(acompanhamentoOrdemServico);
    }

    @Override
    public List<Optional<AcompanhamentoOrdemServico>> findByOrdemServicoId(Integer id) {
        List<Optional<AcompanhamentoOrdemServico>> lista = repository.findByOrdemServicoId(id);
        return lista;
    }
}
