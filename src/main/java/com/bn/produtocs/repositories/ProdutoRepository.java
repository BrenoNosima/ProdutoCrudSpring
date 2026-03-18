package com.bn.produtocs.repositories;

import com.bn.produtocs.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long> {
}
