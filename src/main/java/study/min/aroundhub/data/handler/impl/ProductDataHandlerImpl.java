package study.min.aroundhub.data.handler.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.min.aroundhub.data.dao.ProductDAO;
import study.min.aroundhub.data.entity.Product;
import study.min.aroundhub.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

    private final ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        Product product = new Product(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(product);
    }

    @Override
    public Product getProductEntity(String productId) {
        return productDAO.getProduct(productId);
    }
}
