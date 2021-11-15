package com.example.projuris.controller;

import com.example.projuris.model.Cliente;
import com.example.projuris.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Cliente> add (@Valid @RequestBody Cliente cliente){

        System.out.println("cliente: "+cliente);
        cliente = clienteService.insert(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Cliente>> find (@PathVariable Integer id){
        Optional<Cliente> cli = clienteService.findById(id);

        return ResponseEntity.ok().body(cli);
    }

}
