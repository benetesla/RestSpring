package br.com.projetos.api.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Mensagem {
    private String mensagem;
}
