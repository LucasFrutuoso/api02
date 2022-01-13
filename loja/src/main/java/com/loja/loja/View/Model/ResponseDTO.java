package com.loja.loja.View.Model;

import com.loja.loja.Model.Produtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private Integer id;

    private Integer Qtd;

    private Double preco;

    private String nome;

    private String descricao;

    
    public ResponseDTO(Produtos produtos){
        this.setId(produtos.getId());
        this.setDescricao(produtos.getDescricao());
        this.setNome(produtos.getNome());
        this.setQtd(produtos.getQtd());
    }
}
