package br.com.zupacademy.joao.casadocodigo.repositoy;

import br.com.zupacademy.joao.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
