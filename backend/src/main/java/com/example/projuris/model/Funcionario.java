package com.example.projuris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_id_seq")
    @SequenceGenerator(name = "funcionario_id_seq", sequenceName = "funcionario_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "matricula", nullable = false)
    private String matricula;

//    @JsonIgnore
//    @OneToMany(mappedBy = "funcionario")
//    private List<OrdemServico> ordemServico;

}
