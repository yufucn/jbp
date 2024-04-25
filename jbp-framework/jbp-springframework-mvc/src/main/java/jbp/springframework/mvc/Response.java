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
    private String code = "success";
    private T data;
    private String message;
    private Map<String, String> errors;

    public Response success() {
        this.setCode("success");
        return this;
    }

    public Response fail() {
        this.setCode("fail");
        return this;
    }
}
