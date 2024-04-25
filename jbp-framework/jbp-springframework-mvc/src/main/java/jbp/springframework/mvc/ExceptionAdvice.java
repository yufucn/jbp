package jbp.springframework.mvc;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
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

    @ExceptionHandler(RuntimeException.class)
    public Object notFount(RuntimeException e) {
        return Response.builder()
                .message(e.getMessage())
                .code("fail")
                .build();
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        return Response.builder()
                .message(e.getMessage())
                .code("fail")
                .build();
    }
}
