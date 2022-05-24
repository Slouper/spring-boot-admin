package cz.inventi.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.UnexpectedTypeException;

import static java.lang.String.format;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {UnexpectedTypeException.class,
                               MethodArgumentNotValidException.class,
                               IllegalStateException.class,
                               IllegalArgumentException.class,
                               IllegalStateException.class})
    protected Error handleUnexpectedTypeException(Exception ex) {
        String body = format("The request is not valid. See the reason further:\n[%s]\n[%s]", ex.getLocalizedMessage(), ex.getCause());
        return new Error(body);
    }

    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public ResponseEntity<Object> defaultErrorHandler(Exception ex) {
        return ResponseEntity.internalServerError().body(new Error(format("Internal server error.\n%s", ex)));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Error {
        private String message;
    }
}