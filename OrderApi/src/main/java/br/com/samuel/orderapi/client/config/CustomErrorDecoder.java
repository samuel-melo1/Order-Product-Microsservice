package br.com.samuel.orderapi.client.config;

import br.com.samuel.orderapi.service.exception.ObjectNotFoundException;
import br.com.samuel.orderapi.service.response.StatusErrorEnum;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String key, Response response) {

        switch (response.status()){
            case 404:
                return new ObjectNotFoundException(StatusErrorEnum.NOT_FOUND);
            default:
                return new Exception("Exception while getting product details");
        }

    }
}
