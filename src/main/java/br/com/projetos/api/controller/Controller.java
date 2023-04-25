package br.com.projetos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetos.api.model.Pessoa;
import br.com.projetos.api.repository.Repositorio;
import br.com.projetos.api.service.Servico;

@RestController
public class Controller {
    @Autowired
    private Repositorio acao;
    @Autowired
    private Servico  servico;


    // post
    @PostMapping("/api")
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return servico.cadastra(pessoa);
    }    
    // delete
    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Integer codigo) {
        return servico.deleta(codigo);
    }
    // get
    @GetMapping("/api")
    public ResponseEntity<?> buscarPessoas() {
        return servico.buscaTodos();
    }
    // get
    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> buscarPessoa(@PathVariable Integer codigo) {
        return servico.busca(codigo);
    }

    // get
    public void maiorIdade( int idade) {
        List<Pessoa> lista = acao.maiorIdade(idade);
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa.getNome());
        }
    }
}
