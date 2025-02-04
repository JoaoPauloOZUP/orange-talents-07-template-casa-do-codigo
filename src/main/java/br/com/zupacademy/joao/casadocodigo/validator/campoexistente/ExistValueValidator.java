package br.com.zupacademy.joao.casadocodigo.validator.campoexistente;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistValueValidator implements ConstraintValidator<ExistValue, Object> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ExistValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM "+klass.getName()+" WHERE "+domainAttribute+"= :value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
