package com.example.projuris.controller;

import com.example.projuris.model.Equipamento;
import com.example.projuris.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/equipamento")
@RestController
public class EquipamentoController {

    @Autowired
    private EquipamentoService equipamentoService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Equipamento> add (@Valid @RequestBody Equipamento equipamento){

        equipamento = equipamentoService.insert(equipamento);
        return ResponseEntity.ok().body(equipamento);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Equipamento>> find (@PathVariable Integer id){

        Optional<Equipamento> equipamento = equipamentoService.findById(id);
        return ResponseEntity.ok().body(equipamento);
    }
}
