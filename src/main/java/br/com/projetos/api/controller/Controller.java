package br.com.projetos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.api.model.Pessoa;
import br.com.projetos.api.repository.Repositorio;

@RestController
public class Controller {

    @Autowired
    private Repositorio acao;
    @PostMapping("/api")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa){
        return acao.save(pessoa);
    }
    @GetMapping("/api")
    public List<Pessoa> listarPessoas(){
        return acao.findAll();
    }
    @GetMapping("/api/{codigo}")
    public Pessoa buscarPessoa(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }
    
    @GetMapping("/")
    public String saudacao(){
        return "Olá, seja bem vindo!";
    }
}
