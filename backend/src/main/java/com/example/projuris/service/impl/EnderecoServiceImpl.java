package com.example.projuris.service.impl;

import com.example.projuris.model.Endereco;
import com.example.projuris.repository.EnderecoRepository;
import com.example.projuris.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    public Optional<Endereco> findById(Integer id) {
        return enderecoRepository.findById(id);
    }

    @Override
    public Endereco insert(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco update(Endereco endereco) {
        Optional<Endereco> optionalEndereco = findById(endereco.getId());

        if (optionalEndereco.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }

        optionalEndereco.get().setId(endereco.getId());
        return enderecoRepository.save(optionalEndereco.get());
    }
}
