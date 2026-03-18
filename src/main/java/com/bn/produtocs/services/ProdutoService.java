package com.bn.produtocs.services;

import com.bn.produtocs.models.ProdutoModel;
import com.bn.produtocs.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }

    public ProdutoModel procurarPorId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

}