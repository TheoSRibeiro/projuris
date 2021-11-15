package com.example.projuris.controller;

import com.example.projuris.model.Endereco;
import com.example.projuris.service.EnderecoService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/endereco")
@RestController
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Endereco> add (@Valid @RequestBody Endereco endereco){
        System.out.println("endereco: "+endereco);
        enderecoService.insert(endereco);
        return new ResponseEntity<Endereco>(HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Endereco>> find (@PathVariable Integer id){

        Optional<Endereco> endereco = enderecoService.findById(id);
        return ResponseEntity.ok().body(endereco);
    }
}
