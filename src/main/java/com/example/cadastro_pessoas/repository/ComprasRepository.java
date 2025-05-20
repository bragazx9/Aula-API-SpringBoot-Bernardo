package com.example.cadastro_pessoas.repository;

import com.example.cadastro_pessoas.model.ComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComprasRepository extends JpaRepository<ComprasModel, Long> {


    List<ComprasModel> findByPessoaId(Long pessoaId);
}
