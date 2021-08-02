package br.com.zupacademy.joao.casadocodigo.repositoy;

import br.com.zupacademy.joao.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
