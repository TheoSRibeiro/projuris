package com.example.projuris.service;

import com.example.projuris.model.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoService {
    List<OrdemServico> findAll();

    Optional<OrdemServico> findById(Integer id);

    List<Optional<OrdemServico>> findByFuncionarioId(Integer id);

    OrdemServico insert (OrdemServico ordemServico);

    OrdemServico inicioServico(OrdemServico ordemServico);

    OrdemServico update(OrdemServico ordemServico);
}
