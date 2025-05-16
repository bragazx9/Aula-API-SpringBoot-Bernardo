package com.example.cadastro_pessoas.controller;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.servicer.ProdutosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutosModel salvar(@RequestBody ProdutosModel produtoModel) {
        return service.salvar(produtoModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar(@PathVariable Long id, @RequestBody ProdutosModel produtoModel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoModel.setId(id);
        return ResponseEntity.ok(service.salvar(produtoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
