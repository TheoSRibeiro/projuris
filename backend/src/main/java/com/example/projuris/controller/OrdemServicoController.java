package com.example.projuris.controller;

import com.example.projuris.model.OrdemServico;
import com.example.projuris.service.OrdemServicoService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/ordem-servico")
@RestController
public class OrdemServicoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping(value = "/insert")
    public ResponseEntity<OrdemServico> insert (@Valid @RequestBody OrdemServico ordemServico){

        ordemServico = ordemServicoService.insert(ordemServico);
        return ResponseEntity.ok().body(ordemServico);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<OrdemServico>> findById (@PathVariable Integer id){

        Optional<OrdemServico> ordemServico = ordemServicoService.findById(id);
        return ResponseEntity.ok().body(ordemServico);
    }

    @GetMapping(value = "/funcionario/{id}")
    public ResponseEntity<List<Optional<OrdemServico>>> findByFuncionarioId (@PathVariable Integer id){

        List<Optional<OrdemServico>> ordemServico = ordemServicoService.findByFuncionarioId(id);
        return ResponseEntity.ok().body(ordemServico);
    }

    @PatchMapping(value = "/inicio/{id}")
    public ResponseEntity<Optional<OrdemServico>> iniciarServico (@PathVariable Integer id){

        System.out.println("ID: "+id);

        Optional<OrdemServico> ordem  = ordemServicoService.iniciarServico(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/servico-iniciado/funcionario/{id}")
    public ResponseEntity<List<Optional<OrdemServico>>> findServicosIniciadosFuncionarioId (@PathVariable Integer id){

        List<Optional<OrdemServico>> lista  = ordemServicoService.findServicosIniciadosFuncionarioId(id);

        return ResponseEntity.ok().body(lista);
    }

    @PatchMapping(value = "/fim/{id}")
    public ResponseEntity<Optional<OrdemServico>> finalizarServico (@PathVariable Integer id){

        System.out.println("ID: "+id);

        //Atualizar ordem de servico
        Optional<OrdemServico> ordem  = ordemServicoService.finalizarServico(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/servico-finalizado/funcionario/{id}")
    public ResponseEntity<List<Optional<OrdemServico>>> findServicosFinalizadosFuncionarioId (@PathVariable Integer id){

        List<Optional<OrdemServico>> lista  = ordemServicoService.findServicosFinalizadosFuncionarioId(id);

        return ResponseEntity.ok().body(lista);
    }


}
