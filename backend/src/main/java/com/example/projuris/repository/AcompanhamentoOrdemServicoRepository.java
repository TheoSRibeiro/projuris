package com.example.projuris.repository;

import com.example.projuris.model.AcompanhamentoOrdemServico;
import com.example.projuris.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcompanhamentoOrdemServicoRepository extends JpaRepository<AcompanhamentoOrdemServico, Integer> {


    @Query(value = "SELECT * FROM acompanhamento_ordem_servico aos WHERE aos.ordem_servico_id = :osId", nativeQuery = true)
    List<Optional<AcompanhamentoOrdemServico>> findByOrdemServicoId(@Param("osId") Integer osId);
}
