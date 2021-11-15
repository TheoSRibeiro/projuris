package com.example.projuris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_seq")
    @SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToOne(mappedBy = "cliente")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Equipamento> equipamentos = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "cliente")
    private OrdemServico ordemServico;


}