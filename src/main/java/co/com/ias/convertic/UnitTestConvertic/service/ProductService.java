package co.com.ias.convertic.UnitTestConvertic.service;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import co.com.ias.convertic.UnitTestConvertic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProducts() { return productRepository.findAll(); }
}
