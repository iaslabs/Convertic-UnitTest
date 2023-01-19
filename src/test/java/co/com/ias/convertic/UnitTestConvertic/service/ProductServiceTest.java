package co.com.ias.convertic.UnitTestConvertic.service;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import co.com.ias.convertic.UnitTestConvertic.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    @DisplayName("Save product success")
    void saveProduct() {
        //Arrange
        Product product = new Product("Camisa", 50000, "Manga corta");
        product.setId(3L);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        //Act
        Product result = productService.saveProduct(product);


        //Assert
        assertNotNull(result);
        assertInstanceOf(Product.class, result);
        assertEquals("Camisa", result.getName());


    }
}