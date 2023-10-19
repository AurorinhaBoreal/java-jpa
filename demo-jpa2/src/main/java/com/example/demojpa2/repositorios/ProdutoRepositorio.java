package com.example.demojpa2.repositorios;

import com.example.demojpa2.entidades.Produto;

public interface ProdutoRepositorio {
    Produto buscarPorId(long id);
    Produto cadastrar(Produto produto);
}
