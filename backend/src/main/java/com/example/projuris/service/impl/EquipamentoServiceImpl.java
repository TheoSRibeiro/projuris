package com.example.projuris.service.impl;

import com.example.projuris.model.Equipamento;
import com.example.projuris.repository.EquipamentoRepository;
import com.example.projuris.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Override
    public List<Equipamento> findAll() {
        return equipamentoRepository.findAll();
    }

    @Override
    public Optional<Equipamento> findById(Integer id) {
        return equipamentoRepository.findById(id);
    }

    @Override
    public Equipamento insert(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    @Override
    public Equipamento update(Equipamento equipamento) {
        Optional<Equipamento> optionalEquipamento = findById(equipamento.getId());

        if (optionalEquipamento.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        optionalEquipamento.get().setId(equipamento.getId());
        return equipamentoRepository.save(optionalEquipamento.get());
    }
}
