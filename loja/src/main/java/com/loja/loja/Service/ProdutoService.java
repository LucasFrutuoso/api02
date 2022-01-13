package com.loja.loja.Service;

import java.util.ArrayList;
import java.util.List;
import com.loja.loja.Model.Produtos;
import com.loja.loja.Repository.ProdutoRepository;
import com.loja.loja.Shared.ProdutoDto;
import com.loja.loja.View.Model.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoDto> consultarTodos() {

        List<Produtos> produtos = repository.findAll();
        List<ProdutoDto> adicionar = new ArrayList<>();

        for (Produtos prod : produtos) {

            ProdutoDto dto = new ProdutoDto(prod);
            adicionar.add(dto);

        }
        return adicionar;
    }

    public ResponseDTO consultarPorId(Integer id){

        Produtos produto = repository.findById(id).orElse(null);

        ResponseDTO response = new ResponseDTO(produto);

        // response.setDescricao(produto.getDescricao());
        // response.setPreco(produto.getPreco());
        // response.setNome(produto.getNome());
        // response.setQtd(produto.getQtd());
        // response.setId(produto.getId());

        return response;
    }

    public ResponseDTO adicionar(ProdutoDto dto){

        Produtos produto = new Produtos();

        produto.setDescricao(dto.getDescricao());
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());;
        produto.setQtd(dto.getQtd());

        repository.save(produto);

        ResponseDTO response = new ResponseDTO();

        response.setDescricao(produto.getDescricao());
        response.setPreco(produto.getPreco());
        response.setNome(produto.getNome());
        response.setQtd(produto.getQtd());
        response.setId(produto.getId());
    
        return response;
    
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }


    public ResponseDTO atualizar(Integer id, ProdutoDto produto){

    produto.setId(id);

    Produtos produtos = repository.findById(id).orElse(null);

    produtos.setDescricao(produto.getDescricao());
    produtos.setNome(produto.getDescricao());
    produtos.setPreco(produto.getPreco());;
    produtos.setQtd(produto.getQtd());

    repository.save(produtos);

    ResponseDTO response = new ResponseDTO();

    response.setDescricao(produto.getDescricao());
    response.setPreco(produto.getPreco());
    response.setNome(produto.getNome());
    response.setQtd(produto.getQtd());
    response.setId(produto.getId());

    return response;

    


    }
}
