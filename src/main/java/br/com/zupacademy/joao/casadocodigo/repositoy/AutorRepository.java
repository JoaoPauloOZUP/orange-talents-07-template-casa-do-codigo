package br.com.zupacademy.joao.casadocodigo.repositoy;

import br.com.zupacademy.joao.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
