package com.example.cadastro_pessoas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ItensCompra")
@Getter
@Setter
@NoArgsConstructor
public class ItemCompraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private ComprasModel compra;  // Relacionamento com a tabela de Compras

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutosModel produto;  // Assumindo que já existe a classe ProdutoModel

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;  // Preço do produto na compra

    @PrePersist
    public void prePersist() {
        // Aqui você pode adicionar alguma lógica antes de persistir os dados, se necessário
    }
}
