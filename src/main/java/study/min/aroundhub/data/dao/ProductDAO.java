package study.min.aroundhub.data.dao;

import study.min.aroundhub.data.entity.Product;

public interface ProductDAO {
    Product saveProduct(Product product);
    Product getProduct(String productId);
}
