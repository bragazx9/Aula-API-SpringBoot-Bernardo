package com.example.cadastro_pessoas.servicer
;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<ProdutosModel> listarTodos() {
        return produtosRepository.findAll();
    }

    public Optional<ProdutosModel> buscarPorId(Long id) {
        return produtosRepository.findById(id);
    }

    public ProdutosModel salvar(ProdutosModel produto) {
        return produtosRepository.save(produto);
    }

    public ProdutosModel atualizar(Long id, ProdutosModel novoProduto) {
        return produtosRepository.findById(id).map(produto -> {
            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());
            produto.setQuantidadeEstoque(novoProduto.getQuantidadeEstoque());
            produto.setDescricao(novoProduto.getDescricao());
            return produtosRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("produto nao encontrado: " + id));
    }

    public void deletar(Long id) {
        if (!produtosRepository.existsById(id)) {
            throw new RuntimeException("produto nao encntardo " + id);
        }
        produtosRepository.deleteById(id);
    }
}