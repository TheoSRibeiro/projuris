package com.example.projuris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_id_seq")
    @SequenceGenerator(name = "endereco_id_seq", sequenceName = "endereco_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "municipio", length = 50, nullable = false)
    private String municipio;

    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @Column(name = "logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name = "numero", length = 5)
    private String numero;

    @Column(name = "complemento", length = 200)
    private String complemento;

//    @OneToOne
//    @JoinColumn(name = "cliente_id")
//    private Cliente cliente;

    @Column(name = "cliente_id", length = 200)
    private Integer clienteId;

}
