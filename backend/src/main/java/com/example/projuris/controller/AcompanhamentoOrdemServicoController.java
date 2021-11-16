package com.example.projuris.controller;

import com.example.projuris.model.AcompanhamentoOrdemServico;
import com.example.projuris.model.OrdemServico;
import com.example.projuris.service.AcompanhamentoOrdemServicoService;
import com.example.projuris.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/acompanhamento-ordem-servico")
@RestController
public class AcompanhamentoOrdemServicoController {

    @Autowired
    private AcompanhamentoOrdemServicoService service;

    @PostMapping(value = "/insert")
    public ResponseEntity<AcompanhamentoOrdemServico> insert (@Valid @RequestBody AcompanhamentoOrdemServico acompanhamento){

        acompanhamento = service.insert(acompanhamento);
        return ResponseEntity.ok().body(acompanhamento);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<AcompanhamentoOrdemServico>> findById (@PathVariable Integer id){

        Optional<AcompanhamentoOrdemServico> acompanhamento = service.findById(id);
        return ResponseEntity.ok().body(acompanhamento);
    }

    @GetMapping(value = "ordem-servico/{id}")
    public ResponseEntity<List<Optional<AcompanhamentoOrdemServico>>> findByOrdemServicoId (@PathVariable Integer id){

        List<Optional<AcompanhamentoOrdemServico>> acompanhamentos = service.findByOrdemServicoId(id);
        return ResponseEntity.ok().body(acompanhamentos);
    }

}
