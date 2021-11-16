package com.example.projuris.service;

import com.example.projuris.model.OrdemServico;

import java.util.List;
import java.util.Optional;

public interface OrdemServicoService {
    List<OrdemServico> findAll();

    Optional<OrdemServico> findById(Integer id);

    List<Optional<OrdemServico>> findByFuncionarioId(Integer id);

    OrdemServico insert (OrdemServico ordemServico);

    Optional<OrdemServico> iniciarServico(Integer id);

    List<Optional<OrdemServico>>findServicosIniciadosFuncionarioId(Integer id);

    List<Optional<OrdemServico>>findServicosFinalizadosFuncionarioId(Integer id);

    Optional<OrdemServico> finalizarServico(Integer id);

    OrdemServico update(OrdemServico ordemServico);
}
