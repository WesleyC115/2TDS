package com.example.senai.View;


import com.example.senai.Model.Produto;
import com.example.senai.Controller.ProdutoController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/produto")
public class TesteProduto {
    //instanciando um novo produto
    public Produto produto = new Produto(1,"Sabonete","Sabonete hidratante floral",1.79,15,"Savegnago");

    //Get - retorna os dados do produto
    @GetMapping
    public Produto getProduto() {
        return produto;
    }

    //Post -  cria ou substitui o produto com os dados enviados na requisição
    @PostMapping
    public Produto addProduto(@RequestBody Produto ProdutoAdicionado) {
        this.produto = ProdutoAdicionado;
        return this.produto;
    }

    //Put - atualiza os dados do produto
    @PutMapping
    public Produto atlzProduto(@RequestBody Produto ProdutoAtualizado) {
        if (this.produto != null) {
            this.produto.setIdProduto(ProdutoAtualizado.getIdProduto());
            this.produto.setNomeProduto(ProdutoAtualizado.getNomeProduto());
            this.produto.setDescricao(ProdutoAtualizado.getDescricao());
            this.produto.setPreco(ProdutoAtualizado.getPreco());
            this.produto.setQuantidade(ProdutoAtualizado.getQuantidade());
            this.produto.setPontoDeVenda(ProdutoAtualizado.getPontoDeVenda());

        }
        return this.produto;
    }

    //Delete - "deleta" o produto (neste exemplo, apenas setamos o objeto como null)
    @DeleteMapping
    public String deletarProduto() {
        this.produto = null;
        return "Produto deletado!";
    }

}
