package com.example.projuris.service;

import com.example.projuris.model.AcompanhamentoOrdemServico;
import com.example.projuris.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface AcompanhamentoOrdemServicoService {

    List<AcompanhamentoOrdemServico> findAll();

    Optional<AcompanhamentoOrdemServico> findById(Integer id);

    List<Optional<AcompanhamentoOrdemServico>> findByOrdemServicoId(Integer id);

    AcompanhamentoOrdemServico insert (AcompanhamentoOrdemServico acompanhamentoOrdemServico);
}
