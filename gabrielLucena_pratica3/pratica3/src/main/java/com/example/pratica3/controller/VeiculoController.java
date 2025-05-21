package com.example.pratica3.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pratica3.model.Veiculo;
import com.example.pratica3.service.VeiculoService;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService pessoaService){
        this.veiculoService = pessoaService;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id){
        return veiculoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.salvarVeiculo(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }

}
