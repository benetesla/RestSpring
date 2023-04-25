package br.com.projetos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projetos.api.model.Pessoa;
import br.com.projetos.api.repository.Repositorio;
@RestController
public class Controller {
    @Autowired
    private Repositorio acao;
    @PostMapping("/api")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa); 
    }

    @GetMapping("/api/order")
    public List<Pessoa> listarPessoasOrdenadas() {
        return acao.findByOrderByNome();
    }
    @GetMapping("/api")
    public List<Pessoa> listarPessoas() {
        return acao.findAll();
    }
    @GetMapping("/api/count")
    public long contatarPessoas() {
        return acao.count();
    }
    @PutMapping("/api/editar")
    public Pessoa editarPessoa(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa);
    }
    @DeleteMapping("/api/{codigo}")    
    public void removerPessoa(@PathVariable int codigo) {
        acao.deleteById(codigo);
    }

   
    @GetMapping("/")
    public String saudacao() {
        return "Olá, seja bem vindo!";
    }
}