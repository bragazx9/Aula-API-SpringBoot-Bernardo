package com.example.cadastro_pessoas.controller;

import com.example.cadastro_pessoas.model.ItemCompraModel;
import com.example.cadastro_pessoas.servicer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itens-compra")
public class ItemCompraController {

    @Autowired
    private ItemCompraService ItemCompraService;

    @PostMapping
    public ResponseEntity<ItemCompraModel> registrarItemCompra(@RequestBody ItemCompraModel itemCompra) {
        ItemCompraModel savedItemCompra = ItemCompraService.registrarItemCompra(itemCompra);
        return ResponseEntity.ok(savedItemCompra);
    }

    @GetMapping("/compra/{compraId}")
    public List<ItemCompraModel> listarItensPorCompra(@PathVariable Long compraId) {
        return ItemCompraService.listarItensPorCompra(compraId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCompraModel> buscarItemCompraPorId(@PathVariable Long id) {
        ItemCompraModel itemCompra = ItemCompraService.buscarItemCompraPorId(id);
        if (itemCompra != null) {
            return ResponseEntity.ok(itemCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarItemCompra(@PathVariable Long id) {
        ItemCompraService.cancelarItemCompra(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCompraModel> atualizarItemCompra(
            @PathVariable Long id, 
            @RequestBody ItemCompraModel itemCompraAtualizado) {
        
        ItemCompraModel updatedItemCompra = ItemCompraService.atualizarItemCompra(id, itemCompraAtualizado);
        if (updatedItemCompra != null) {
            return ResponseEntity.ok(updatedItemCompra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
