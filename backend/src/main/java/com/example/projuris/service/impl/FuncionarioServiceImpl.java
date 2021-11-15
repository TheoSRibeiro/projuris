package com.example.projuris.service.impl;

import com.example.projuris.model.Funcionario;
import com.example.projuris.repository.FuncionarioRepository;
import com.example.projuris.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Optional<Funcionario> findById(Integer id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public Funcionario insert(Funcionario funcionario){ return funcionarioRepository.save(funcionario); }

    @Override
    public Funcionario update(Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = findById(funcionario.getId());

        if (optionalFuncionario.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        optionalFuncionario.get().setId(funcionario.getId());
        return funcionarioRepository.save(optionalFuncionario.get());
    }
}
