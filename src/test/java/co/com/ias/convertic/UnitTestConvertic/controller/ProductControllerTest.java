package co.com.ias.convertic.UnitTestConvertic.controller;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import co.com.ias.convertic.UnitTestConvertic.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Save product success")
    void saveProduct() throws Exception {
        //Arrange
        Product product = new Product("Camisa", 50000, "Manga corta");
        when(productService.saveProduct(any(Product.class))).thenReturn(product);
        ObjectMapper mapper = new ObjectMapper();
        product.setId(1L);

        //Act & assert
        this.mockMvc.perform(post("/api/product").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(product)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Camisa")));


    }
}