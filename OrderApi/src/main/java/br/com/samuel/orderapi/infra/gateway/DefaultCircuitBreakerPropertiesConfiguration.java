package br.com.samuel.orderapi.infra.gateway;
import io.github.resilience4j.springboot3.circuitbreaker.autoconfigure.CircuitBreakerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class DefaultCircuitBreakerPropertiesConfiguration implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)  {
        if (bean instanceof CircuitBreakerProperties) {
            CircuitBreakerProperties circuitBreakerProperties = (CircuitBreakerProperties) bean;
            circuitBreakerProperties.getInstances()
                    .values()
                    .stream()
                    .filter(instanceProperties -> Objects.isNull(instanceProperties.getBaseConfig()))
                    .forEach(instanceProperties -> instanceProperties.setBaseConfig("default"));
        }
        return bean;
    }

}
