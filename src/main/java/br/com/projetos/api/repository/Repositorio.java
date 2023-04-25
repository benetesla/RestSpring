package br.com.projetos.api.repository;

import br.com.projetos.api.model.Pessoa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer> {
    List<Pessoa> findAll();
    Pessoa findByCodigo(int codigo);
    List<Pessoa> findByOrderByNomeDesc();
    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);
    List<Pessoa> findByNomeContaining(String nome);
    List<Pessoa> findByNomeStartingWith(String nome);
    List<Pessoa> findByNomeEndingWith(String nome);
    @Query(value = "SELECT SUM(idade) FROM pessoa", nativeQuery = true)
    int somaIdade();

    @Query(value = "SELECT * FROM pessoa WHERE idade > 18", nativeQuery = true)
    List<Pessoa> maiorIdade(int idade);
}