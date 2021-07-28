package br.com.zupacademy.joao.casadocodigo.config.excptionhandler;

import br.com.zupacademy.joao.casadocodigo.config.excptionhandler.dto.response.ErroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroResponse> handle(MethodArgumentNotValidException exception) {
        List<ErroResponse> response = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(erro -> {
            ErroResponse erroResponse = new ErroResponse(erro.getField(), messageSource.getMessage(erro, LocaleContextHolder.getLocale()));
            response.add(erroResponse);
        });

        return response;
    }
}
