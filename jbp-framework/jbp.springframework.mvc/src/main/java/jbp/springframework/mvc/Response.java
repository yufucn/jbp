package jbp.springframework.mvc;

import lombok.*;

import java.util.Map;

/**
 * @author wang
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private String code;
    private T data;
    private String message;
    private Map<String, String> errors;
}
