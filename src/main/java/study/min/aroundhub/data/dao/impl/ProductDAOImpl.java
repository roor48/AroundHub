package study.min.aroundhub.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.min.aroundhub.data.dao.ProductDAO;
import study.min.aroundhub.data.entity.Product;
import study.min.aroundhub.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }
}
