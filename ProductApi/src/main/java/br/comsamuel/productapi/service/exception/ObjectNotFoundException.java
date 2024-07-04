package br.comsamuel.productapi.service.exception;

import br.comsamuel.productapi.service.enums.StatusErrorEnum;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(StatusErrorEnum inteceptor){
        super(inteceptor.getMessage());
    }
}
