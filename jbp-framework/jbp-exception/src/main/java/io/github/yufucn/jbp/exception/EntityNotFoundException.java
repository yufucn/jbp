package io.github.yufucn.jbp.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Integer httpStatusCode = 404;
    private String code = "NotFound";

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }
}
