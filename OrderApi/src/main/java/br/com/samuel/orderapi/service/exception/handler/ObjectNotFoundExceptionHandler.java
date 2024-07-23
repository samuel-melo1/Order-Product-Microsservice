package br.com.samuel.orderapi.service.exception.handler;

import br.com.samuel.orderapi.controller.response.RestErrorMessage;
import br.com.samuel.orderapi.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ObjectNotFoundExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    private ResponseEntity<RestErrorMessage> notFound(ObjectNotFoundException exception, HttpServletRequest request) {
        RestErrorMessage message = new RestErrorMessage(Instant.now(), exception.getStatus().value(), exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(exception.getStatus()).body(message);
    }
}
