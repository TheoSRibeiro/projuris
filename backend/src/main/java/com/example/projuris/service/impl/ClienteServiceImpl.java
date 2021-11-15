package com.example.projuris.service.impl;

import com.example.projuris.model.Cliente;
import com.example.projuris.repository.ClienteRepository;
import com.example.projuris.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente insert(Cliente cliente){ return clienteRepository.save(cliente); }

    @Override
    public Cliente update(Cliente cliente) {
        Optional<Cliente> optionalCliente = findById(cliente.getId());

        if (optionalCliente.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        optionalCliente.get().setId(cliente.getId());
        return clienteRepository.save(optionalCliente.get());
    }

}
