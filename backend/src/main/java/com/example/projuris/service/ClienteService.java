package com.example.projuris.service;

import com.example.projuris.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> findAll();

    Optional<Cliente> findById(Integer id);

    Cliente insert (Cliente cliente);

    Cliente update(Cliente cliente);

}
