
package com.example.cadastro_pessoas.model;

import java.math.BigDecimal;

// Importações necessárias para o mapeamento JPA e Lombok
import jakarta.persistence.Column;           
import jakarta.persistence.Entity;          
import jakarta.persistence.GeneratedValue;   
import jakarta.persistence.GenerationType;   
import jakarta.persistence.Id;               
import jakarta.persistence.PrePersist;       
import jakarta.persistence.Table;            
import lombok.Getter;                       
import lombok.NoArgsConstructor;             
import lombok.Setter;                        

// Anotação para informar que esta classe representa uma entidade do banco de dados
@Entity

// Anotação para definir o nome da tabela que será criada no banco
@Table(name = "Produtos") // Aqui você pode mudar para o nome desejado, por exemplo, "pessoas"

// Lombok - Gera automaticamente os métodos getters e setters
@Getter
@Setter

// Lombok - Gera um construtor sem argumentos
@NoArgsConstructor
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    
    @Column(name = "QuantidadeEstoque", nullable = false)
    private Integer QuantidadeEstoque;

     @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, updatable = false)
    private java.time.LocalDateTime createTime;

    @PrePersist
    public void prePersist() {
        this.createTime = java.time.LocalDateTime.now();
    }
}
