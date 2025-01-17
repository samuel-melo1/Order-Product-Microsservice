package br.comsamuel.productapi.service.Impl;

import br.comsamuel.productapi.domain.Product;
import br.comsamuel.productapi.repository.ProductRepository;
import br.comsamuel.productapi.service.ProductService;
import br.comsamuel.productapi.service.enums.StatusErrorEnum;
import br.comsamuel.productapi.service.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product saveProduct(Product product){
        if(!repository.existsById(product.getId_product())){
            LOG.info("saving product");
            return repository.save(product);
        }
        throw new ObjectNotFoundException(StatusErrorEnum.NOT_FOUND);
    }
    @Override
    public Optional<Product> findById(Long id){
        LOG.info("searching products by id");
        return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(StatusErrorEnum.NOT_FOUND)));
    }

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }
}
