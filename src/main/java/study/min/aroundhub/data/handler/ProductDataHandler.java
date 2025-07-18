package study.min.aroundhub.data.handler;

import study.min.aroundhub.data.entity.Product;

public interface ProductDataHandler {
    Product saveProductEntity(String productId, String productName, int productPrice, int productStock);
    Product getProductEntity(String productId);
}
