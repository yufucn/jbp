package io.github.yufucn.jbp.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer httpStatusCode = 403;
    private String code = "Forbidden";

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, String code) {
        super(message);
        this.code = code;
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
