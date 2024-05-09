package io.github.yufucn.jbp.exception;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorizationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer httpStatusCode = 401;
    private String code = "UnAuthorized";

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(String message, String code) {
        super(message);
        this.code = code;
    }

    public AuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
