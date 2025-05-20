package com.example.cadastro_pessoas.servicer;

import com.example.cadastro_pessoas.model.ComprasModel;
import com.example.cadastro_pessoas.model.ItemCompraModel;
import com.example.cadastro_pessoas.repository.ComprasRepository;
import com.example.cadastro_pessoas.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    public ComprasModel registrarCompra(ComprasModel compra) {
        ComprasModel savedCompra = comprasRepository.save(compra);
        for (ItemCompraModel item : compra.getItens()) {
            item.setCompra(savedCompra); 
            itemCompraRepository.save(item);
        }
        return savedCompra;
    }

    public List<ComprasModel> listarCompras() {
        return comprasRepository.findAll();
    }

    public ComprasModel buscarCompraPorId(Long id) {
        return comprasRepository.findById(id).orElse(null);
    }

    public List<ComprasModel> buscarComprasPorPessoa(Long pessoaId) {
        return comprasRepository.findByPessoaId(pessoaId);
    }

    public void cancelarCompra(Long id) {
        ComprasModel compra = comprasRepository.findById(id).orElse(null);
        if (compra != null) {
            comprasRepository.delete(compra);
        }
    }
}
