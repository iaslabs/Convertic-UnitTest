package co.com.ias.convertic.UnitTestConvertic.repository;

import co.com.ias.convertic.UnitTestConvertic.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
