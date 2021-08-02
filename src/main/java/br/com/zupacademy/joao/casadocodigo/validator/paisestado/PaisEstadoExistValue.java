package br.com.zupacademy.joao.casadocodigo.validator.paisestado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {PaisEstadoExistValueValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PaisEstadoExistValue {

    String message() default "{ }";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
