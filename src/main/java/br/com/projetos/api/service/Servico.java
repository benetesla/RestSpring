package br.com.projetos.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projetos.api.model.Mensagem;
import br.com.projetos.api.model.Pessoa;
import br.com.projetos.api.repository.Repositorio;

@Service
public class Servico {
    @Autowired
    private Mensagem mensagem;
    @Autowired
    private Repositorio acao;


    /*
     * Este metodo realizar o cadastramento de uma pessoa
     */
    public ResponseEntity<?> cadastra(Pessoa obj) {
        if (obj.getNome().equals("")) {
            mensagem.setMensagem("Nome não pode ser vazio");
            return ResponseEntity.badRequest().body(mensagem);
        } else if (obj.getIdade() < 0) {
            mensagem.setMensagem("Idade não pode ser negativa");
            return ResponseEntity.badRequest().body(mensagem);
        } else {
            mensagem.setMensagem("Cadastro realizado com sucesso");
            return ResponseEntity.ok().body(acao.save(obj));
        }
    }

    /*
     * Este metodo seleciona uma pessoa pelo codigo
     */
     
     public ResponseEntity<?> busca(Integer codigo) {
        if (acao.existsById(codigo)) {
            return ResponseEntity.ok().body(acao.findById(codigo));
        } else {
            mensagem.setMensagem("Codigo não encontrado");
            return ResponseEntity.badRequest().body(mensagem);
        }
     }

    /*
    *este metodo seleciona todas as pessoas
    */

    public ResponseEntity<?> buscaTodos() {
        return ResponseEntity.ok().body(acao.findAll());
    }
    /*
     * Atualiza uma pessoa pelo codigo
     */

     public ResponseEntity<?> atualiza(Pessoa obj, Integer codigo) {
        if (acao.existsById(codigo)) {
            obj.setCodigo(codigo);
            return ResponseEntity.ok().body(acao.save(obj));
        } else {
            mensagem.setMensagem("Codigo não encontrado");
            return ResponseEntity.badRequest().body(mensagem);
        }
    }
    /*
     * Deleta uma pessoa pelo codigo
     */
     
     public ResponseEntity<?> deleta(Integer codigo) {
        if (acao.existsById(codigo)) {
            acao.deleteById(codigo);
            mensagem.setMensagem("Pessoa deletada com sucesso");
            return ResponseEntity.ok().body(mensagem);
        } else {
            mensagem.setMensagem("Codigo não encontrado");
            return ResponseEntity.badRequest().body(mensagem);
        }
    }

    
}
