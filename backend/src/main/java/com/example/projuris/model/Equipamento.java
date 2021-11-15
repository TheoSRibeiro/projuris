package com.example.projuris.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "equipamento")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento_id_seq")
    @SequenceGenerator(name = "equipamento_id_seq", sequenceName = "equipamento_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @Column(name = "marca", nullable = false, length = 20)
    private String marca;

    @Column(name = "problema", nullable = false)
    private String problema;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(mappedBy = "equipamento")
    @JsonIgnore
    private OrdemServico ordemServico;

}
