package com.example.projuris.service;


import com.example.projuris.model.Equipamento;

import java.util.List;
import java.util.Optional;

public interface EquipamentoService {
    List<Equipamento> findAll();

    Optional<Equipamento> findById(Integer id);

    Equipamento insert (Equipamento equipamento);

    Equipamento update(Equipamento equipamento);
}
