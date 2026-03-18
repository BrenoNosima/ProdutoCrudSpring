package com.bn.produtocs.controllers;

import com.bn.produtocs.models.ProdutoModel;
import com.bn.produtocs.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> salvar(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.criar(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/produtos/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar() {
        List<ProdutoModel> request = produtoService.listar();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> procurarPorId(@PathVariable Long id) {
        ProdutoModel request = produtoService.procurarPorId(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
