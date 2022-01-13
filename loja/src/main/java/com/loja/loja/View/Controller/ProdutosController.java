package com.loja.loja.View.Controller;

import java.util.List;
import com.loja.loja.Service.ProdutoService;
import com.loja.loja.Shared.ProdutoDto;
import com.loja.loja.View.Model.ResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<?> consultar(){

    List<ProdutoDto> response = service.consultarTodos();
    return ResponseEntity.ok().body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> porId(@PathVariable Integer id){

        ResponseDTO response = service.consultarPorId(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoDto produtosDTO){

        ResponseDTO response = service.adicionar(produtosDTO);
        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody ProdutoDto dto, @PathVariable Integer id){

        ResponseDTO response = service.consultarPorId(id);
        return ResponseEntity.ok().body(response);

    }


}
