package br.com.projetos.api.repository;

import br.com.projetos.api.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    List<Pessoa> findAll();
    Pessoa findByCodigo(int codigo);
    List<Pessoa> findByOrderByNomeDesc();
    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);
}