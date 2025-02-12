package com.example.senai.Controller;


import com.example.senai.DataBase.BancoDeProdutos;
import com.example.senai.Model.Produto;

import java.util.List;

public class ProdutoController {

    BancoDeProdutos bc = new BancoDeProdutos();

    public void inserirNoBanco(Produto p) {
        bc.insert(p);
    }

    public List<Produto> pegarTodosOsProdutos() {
        return bc.findAll();
    }
}