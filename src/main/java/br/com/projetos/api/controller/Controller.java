package br.com.projetos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    // post
    @PostMapping("/api")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa);
    }
    // put
    @PutMapping("/api/editar")
    public Pessoa editarPessoa(@RequestBody Pessoa pessoa) {
        return acao.save(pessoa);
    }
    // delete
    @DeleteMapping("/api/{codigo}")
    public void removerPessoa(@PathVariable int codigo) {
        acao.deleteById(codigo);
    }
    // get
    @GetMapping("/api")
    public List<Pessoa> listarPessoas() {
        return acao.findAll();
    }

    @GetMapping("/api/count")
    public long contatarPessoas() {
        return acao.count();
    }
    @GetMapping("/api/order")
    public List<Pessoa> listarPessoasOrdenadas() {
        return acao.findByOrderByNomeDesc();
    }
    @GetMapping("/api/orderName")
    public List<Pessoa> orderName() {
        return acao.findByNomeOrderByIdadeDesc("Benevanio");
    }
    @GetMapping("/api/NomeContem")
    public List<Pessoa> NomeContem() {
        return acao.findByNomeContaining("Benevanio");
    }
    @GetMapping("/api/NomeContem2")
    public List<Pessoa> NomeContem2() {
        return acao.findByNomeStartingWith("B");
    }
    @GetMapping("/api/NomeContem3")
    public List<Pessoa> NomeContem3() {
        return acao.findByNomeEndingWith("D");
    }
    @GetMapping("/api/somaIdades")
    public int somaIdade() {
        return acao.somaIdade();
    }
    @GetMapping("/api/maiorIdade")
    public List<Pessoa> maiorIdade() {
        return acao.maiorIdade(25);
    }
    @GetMapping("/api/status")
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}