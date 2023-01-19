package co.com.ias.convertic.UnitTestConvertic.controller;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import co.com.ias.convertic.UnitTestConvertic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    Product saveProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @GetMapping("/product")
    List<Product> getProducts(){ return productService.getProducts();}
}
