package com.loja.loja.Shared;

import com.loja.loja.Model.Produtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {
    
    private Integer id;

    private Integer Qtd;

    private Double preco;

    private String nome;

    private String descricao;


    public ProdutoDto(Produtos produtos){
        this.setId(produtos.getId());
        this.setDescricao(produtos.getDescricao());
        this.setNome(produtos.getNome());
        this.setQtd(produtos.getQtd());
    }

    
    
}
