package br.comsamuel.productapi.service.exception;

import br.comsamuel.productapi.service.enums.StatusErrorEnum;
import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException{
    private HttpStatus status;
    public ObjectNotFoundException(StatusErrorEnum inteceptor){
        super(inteceptor.getMessage());
        this.status = inteceptor.getStatus();
    }

    public HttpStatus getStatus() {
        return status;
    }
}
