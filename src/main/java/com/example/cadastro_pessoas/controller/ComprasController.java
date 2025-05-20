package com.example.cadastro_pessoas.controller;

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.servicer.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    @Autowired
    private ComprasService compraService;

    @PostMapping
    public ResponseEntity<ComprasModel> registrarCompra(@RequestBody ComprasModel compra) {
        ComprasModel savedCompra = compraService.registrarCompra(compra);
        return ResponseEntity.ok(savedCompra);
    }

    @GetMapping
    public List<ComprasModel> listarCompras() {
        return compraService.listarCompras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComprasModel> buscarCompraPorId(@PathVariable Long id) {
        ComprasModel compra = compraService.buscarCompraPorId(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pessoa/{pessoaId}")
    public List<ComprasModel> buscarComprasPorPessoa(@PathVariable Long pessoaId) {
        return compraService.buscarComprasPorPessoa(pessoaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarCompra(@PathVariable Long id) {
        compraService.cancelarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
