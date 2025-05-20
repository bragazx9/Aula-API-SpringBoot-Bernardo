package com.example.cadastro_pessoas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Compras")
@Getter
@Setter
@NoArgsConstructor
public class ComprasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataCompra;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private PessoasModel pessoa;  // Assumindo que já existe a classe PessoaModel

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<ItemCompraModel> itens;  // Relacionamento com os itens da compra

    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @PrePersist
    public void prePersist() {
        this.dataCompra = LocalDateTime.now();
        this.createTime = LocalDateTime.now();
    }
}
