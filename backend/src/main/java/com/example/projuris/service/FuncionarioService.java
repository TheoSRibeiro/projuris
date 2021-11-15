package com.example.projuris.service;

import com.example.projuris.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    List<Funcionario> findAll();

    Optional<Funcionario> findById(Integer id);

    Funcionario insert (Funcionario funcionario);

    Funcionario update(Funcionario funcionario);
}
