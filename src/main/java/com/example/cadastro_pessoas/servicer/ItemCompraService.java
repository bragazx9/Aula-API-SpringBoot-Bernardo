package com.example.cadastro_pessoas.servicer;

import com.example.cadastro_pessoas.model.ItemCompraModel;
import com.example.cadastro_pessoas.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCompraService {

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    public ItemCompraModel registrarItemCompra(ItemCompraModel itemCompra) {
        return itemCompraRepository.save(itemCompra);
    }

    public List<ItemCompraModel> listarItensPorCompra(Long compraId) {
        return itemCompraRepository.findByCompraId(compraId);
    }

    public ItemCompraModel buscarItemCompraPorId(Long id) {
        return itemCompraRepository.findById(id).orElse(null);
    }

    public void cancelarItemCompra(Long id) {
        ItemCompraModel itemCompra = itemCompraRepository.findById(id).orElse(null);
        if (itemCompra != null) {
            itemCompraRepository.delete(itemCompra);
        }
    }

    public ItemCompraModel atualizarItemCompra(Long id, ItemCompraModel itemCompraAtualizado) {
        ItemCompraModel itemCompra = itemCompraRepository.findById(id).orElse(null);
        if (itemCompra != null) {
            itemCompra.setQuantidade(itemCompraAtualizado.getQuantidade());
            itemCompra.setPrecoUnitario(itemCompraAtualizado.getPrecoUnitario());
            return itemCompraRepository.save(itemCompra);
        }
        return null;
    }
}
