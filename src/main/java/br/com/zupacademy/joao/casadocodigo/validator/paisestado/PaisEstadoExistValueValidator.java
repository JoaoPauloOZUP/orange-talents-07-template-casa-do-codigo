package br.com.zupacademy.joao.casadocodigo.validator.paisestado;

import br.com.zupacademy.joao.casadocodigo.controller.dto.request.LocalidadeRequest;
import br.com.zupacademy.joao.casadocodigo.model.Estado;
import br.com.zupacademy.joao.casadocodigo.model.Pais;
import br.com.zupacademy.joao.casadocodigo.repositoy.EstadoRepository;
import br.com.zupacademy.joao.casadocodigo.repositoy.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class PaisEstadoExistValueValidator implements ConstraintValidator<PaisEstadoExistValue, LocalidadeRequest> {

    @Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean isValid(LocalidadeRequest value, ConstraintValidatorContext context) {
        Pais pais = paisRepository.findById(value.getPaisId()).get();

        if(!pais.getEstados().isEmpty()) {
            Estado estado = estadoRepository.findById(value.getEstadoId()).get();

            if(pais.getEstados().indexOf(estado) == -1) {
                return false;
            }
        }

        if(value.getEstadoId() != null) {
            return false;
        }

        return true;
    }
}