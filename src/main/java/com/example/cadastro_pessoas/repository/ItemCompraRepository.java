package com.example.cadastro_pessoas.repository;

import com.example.cadastro_pessoas.model.ItemCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemCompraRepository extends JpaRepository<ItemCompraModel, Long> {

    List<ItemCompraModel> findByCompraId(Long compraId);
}
