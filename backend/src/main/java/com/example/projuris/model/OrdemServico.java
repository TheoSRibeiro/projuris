package com.example.projuris.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordem_servico_id_seq")
    @SequenceGenerator(name = "ordem_servico_id_seq", sequenceName = "ordem_servico_id_seq", allocationSize = 1)
    @Column(name = "ordem_servico_id", nullable = false)
    private Integer id;

    @Column(name = "is_pendente")
    private Boolean isPendente;

    @Column(name = "detalhes")
    private String detalhes;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_inicio_servico")
    private LocalDateTime dataInicioServico;

    @Column(name = "data_termino_servico")
    private LocalDateTime dataTerminoServico;

//    @OneToOne
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;
//
//    @ManyToOne
//    @JoinColumn(name = "funcionario_id")
//    private Funcionario funcionario;
//
//    @OneToOne
//    @JoinColumn(name = "equipamento_id")
//    private Equipamento equipamento;

    @Column(name = "cliente_id", nullable = false)
    private Integer clienteId;

    @Column(name = "funcionario_id", nullable = false)
    private Integer funcionarioId;

    @Column(name = "equipamento_id", nullable = false)
    private Integer equipamentoId;




}
