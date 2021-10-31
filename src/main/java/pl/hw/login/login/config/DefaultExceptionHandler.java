package pl.hw.login.login.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.hw.login.login.exception.CustomException;

@ControllerAdvice
@Log4j2
public class DefaultExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        return handleExceptionInternal(ex, new RestException(ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @AllArgsConstructor
    @Getter
    private static class RestException{
        private String errorMessage;
    }

}
