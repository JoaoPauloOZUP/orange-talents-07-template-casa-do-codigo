package br.com.zupacademy.joao.casadocodigo.repositoy;

import br.com.zupacademy.joao.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
