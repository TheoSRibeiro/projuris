package com.example.projuris.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "acompanhamento_ordem_servico")
public class AcompanhamentoOrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acompanhamento_ordem_servico_id_seq")
    @SequenceGenerator(name = "acompanhamento_ordem_servico_id_seq", sequenceName = "acompanhamento_ordem_servico_id_seq", allocationSize = 1)
    @Column(name = "acompanhamento_ordem_servico_id", nullable = false)
    private Integer id;

    @Column(name = "mensagem", nullable = false)
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ordem_servico_id", nullable = false)
    private Integer ordemServicoId;


}
