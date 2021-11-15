package com.example.projuris.controller;

import com.example.projuris.model.Funcionario;
import com.example.projuris.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Funcionario> insert (@Valid @RequestBody Funcionario funcionario){

        System.out.println("funcionario: "+funcionario);
        funcionario = funcionarioService.insert(funcionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Funcionario>> findById (@PathVariable Integer id){
        Optional<Funcionario> cli = funcionarioService.findById(id);

        return ResponseEntity.ok().body(cli);
    }
}
