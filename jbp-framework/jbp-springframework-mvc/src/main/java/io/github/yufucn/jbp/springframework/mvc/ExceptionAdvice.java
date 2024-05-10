package io.github.yufucn.jbp.springframework.mvc;

import io.github.yufucn.jbp.exception.AuthorizationException;
import io.github.yufucn.jbp.exception.EntityNotFoundException;
import io.github.yufucn.jbp.exception.ForbiddenException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionAdvice{

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            result.getFieldErrors().forEach((item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                errorMap.put(field, message);
            });
            return Response.builder()
                    .errors(errorMap)
                    .code("fail")
                    .build();
        }
        return Response.builder().code("fail").build();
    }

    @ExceptionHandler(Throwable.class)
    public Object runtime(RuntimeException ex) {
        String code = "fail";
        if (ex instanceof AuthorizationException) {
            AuthorizationException e = (AuthorizationException) ex;
            code = e.getCode();
        }
        if (ex instanceof ForbiddenException) {
            ForbiddenException e = (ForbiddenException) ex;
            code = e.getCode();
        }
        if (ex instanceof EntityNotFoundException) {
            EntityNotFoundException e = (EntityNotFoundException) ex;
            code = e.getCode();
        }
        return Response.builder()
                .message(ex.getMessage())
                .code(code)
                .build();

    }
}
