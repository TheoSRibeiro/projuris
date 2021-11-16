package com.example.projuris.repository;

import com.example.projuris.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {

    @Query(value = "SELECT * FROM ordem_servico os WHERE os.funcionario_id = :funcionarioId AND is_pendente = 'true'", nativeQuery = true)
    List<Optional<OrdemServico>> findByFuncionarioId(@Param("funcionarioId") Integer funcionarioId);

    @Query(value = "SELECT * FROM ordem_servico os WHERE os.funcionario_id = :funcionarioId AND is_pendente = 'false' AND data_termino_servico is null", nativeQuery = true)
    List<Optional<OrdemServico>> findServicosIniciadosFuncionarioId(@Param("funcionarioId") Integer funcionarioId);

    @Query(value = "SELECT * FROM ordem_servico os WHERE os.funcionario_id = :funcionarioId AND data_termino_servico is not null", nativeQuery = true)
    List<Optional<OrdemServico>> findServicosFinalizadosFuncionarioId(@Param("funcionarioId") Integer funcionarioId);
}
