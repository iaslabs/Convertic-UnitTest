package co.com.ias.convertic.UnitTestConvertic.repository;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("prod")
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("Save product in database success")
    void savedProduct(){
        //Arrange
        Product product = new Product("Camisa", 50000, "Manga corta");

        //Act
        Product savedProduct = productRepository.save(product);
        Optional<Product> queryProduct = productRepository.findById(savedProduct.getId());
        System.out.println(savedProduct.toString());
        //Assert
        assertNotNull(savedProduct);
        assertEquals(savedProduct.getId(), queryProduct.get().getId());
    }

}