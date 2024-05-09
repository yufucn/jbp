package io.github.yufucn.jbp.springframework.mvc;

import io.github.yufucn.jbp.exception.AuthorizationException;
import io.github.yufucn.jbp.exception.EntityNotFoundException;
import io.github.yufucn.jbp.exception.ForbiddenException;
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
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

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
    public ResponseEntity<Object> runtime(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String code = "fail";
        if (ex instanceof AuthorizationException) {
            AuthorizationException e = (AuthorizationException) ex;
            code = e.getCode();
            status = HttpStatus.valueOf(e.getHttpStatusCode());
        }
        if (ex instanceof ForbiddenException) {
            ForbiddenException e = (ForbiddenException) ex;
            code = e.getCode();
            status = HttpStatus.valueOf(e.getHttpStatusCode());
        }
        if (ex instanceof EntityNotFoundException) {
            EntityNotFoundException e = (EntityNotFoundException) ex;
            code = e.getCode();
            status = HttpStatus.valueOf(e.getHttpStatusCode());
        }
        Response<Object> response = Response.builder()
                .message(ex.getMessage())
                .code(code)
                .build();
        return handleExceptionInternal(ex, response,
                new HttpHeaders(), status, request);

    }
}
