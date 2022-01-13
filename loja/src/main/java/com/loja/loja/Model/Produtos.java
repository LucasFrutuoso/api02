package com.loja.loja.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.loja.loja.Shared.ProdutoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer Qtd;

    private Double preco;

    private String nome;

    private String descricao;

    public Produtos(ProdutoDto produtosDto){
        this.setId(produtosDto.getId());
        this.setDescricao(produtosDto.getDescricao());
        this.setNome(produtosDto.getNome());
        this.setQtd(produtosDto.getQtd());
    }
}
