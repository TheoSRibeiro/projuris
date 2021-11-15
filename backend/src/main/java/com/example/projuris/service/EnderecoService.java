package com.example.projuris.service;

import com.example.projuris.model.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {
    List<Endereco> findAll();

    Optional<Endereco> findById(Integer id);

    Endereco insert (Endereco endereco);

    Endereco update(Endereco endereco);
}
