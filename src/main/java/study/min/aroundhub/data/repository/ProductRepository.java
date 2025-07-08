package study.min.aroundhub.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.min.aroundhub.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
