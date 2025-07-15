package study.min.aroundhub.data.repository;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.min.aroundhub.data.entity.ProductEntity;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void GenerateData() {
        int count = 1;
        productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 3000, 9000));
        productRepository.save(getProduct(Integer.toString(--count), count+=2, 1500, 200));
        productRepository.save(getProduct(Integer.toString(count), count++, 4000, 5000));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(count), count++, 1000, 1000));
        productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
        productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(count), count++, 7200, 2000));
        productRepository.save(getProduct(Integer.toString(count), count++, 5100, 1700));
    }

    private ProductEntity getProduct(String id, int nameNumber, int price, int stock) {
        return new ProductEntity(id, "상품" + nameNumber, price, stock);
    }

    //region 주제 키워드
    @Test
    void findTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }

        System.out.println("========== Test Data End ==========");

        List<ProductEntity> foundEntities = productRepository.findByProductName("상품4");

        for (ProductEntity productEntity : foundEntities) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> queryEntities = productRepository.queryByProductName("상품4");

        for (ProductEntity productEntity : queryEntities) {
            System.out.println(productEntity.toString());
        }
    }

    @Test
    void existText() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.existsByProductName("상품4"));
        System.out.println(productRepository.existsByProductName("상품2"));
        System.out.println(productRepository.existsByProductName("상품3"));
    }

    @Test
    void countTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.countByProductName("상품4"));
    }

    @Test
    @Transactional
    void deleteTest() {
        System.out.println("Before : " + productRepository.count());

        productRepository.deleteByProductId("1");
        productRepository.deleteByProductId("9");

        System.out.println("After delete : " + productRepository.count());

        long response = productRepository.removeByProductId("4");

        System.out.println("After remove : " + productRepository.count() + ", response : " + response);
    }

    @Test
    void topTest() {
        productRepository.save(getProduct("100", 123, 1500, 5000));
        productRepository.save(getProduct("101", 123, 2500, 5000));
        productRepository.save(getProduct("102", 123, 3500, 5000));
        productRepository.save(getProduct("103", 123, 4500, 5000));
        productRepository.save(getProduct("104", 123, 1000, 5000));
        productRepository.save(getProduct("105", 123, 2000, 5000));
        productRepository.save(getProduct("106", 123, 3000, 5000));
        productRepository.save(getProduct("107", 123, 4000, 5000));

        List<ProductEntity> foundEntities1 = productRepository.findFirst5ByProductName("상품123");
        for (ProductEntity productEntity : foundEntities1) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> foundEntities2 = productRepository.findTop3ByProductName("상품123");
        for (ProductEntity productEntity : foundEntities2) {
            System.out.println(productEntity.toString());
        }
    }
    //endregion

    //region 조건자 키워드 테스트
    @Test
    void isEqualsTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByProductIdIs("1"));
        System.out.println(productRepository.findByProductIdEquals("9"));
    }

    @Test
    void notTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<ProductEntity> foundEntities1 = productRepository.findByProductIdNot("1");
        for (ProductEntity productEntity : foundEntities1) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> foundEntities2 = productRepository.findByProductIdIsNot("1");
        for (ProductEntity productEntity : foundEntities2) {
            System.out.println(productEntity.toString());
        }
    }

    @Test
    void nullTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByProductStockIsNull());
        System.out.println(productRepository.findByProductStockIsNotNull());
    }

    @Test
    void andTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findTopByProductIdAndProductName("1", "상품1"));
    }

    @Test
    void greaterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        productRepository.save(getProduct("100", 123, 5000, 5000));
        productRepository.save(getProduct("101", 123, 5001, 5000));

        List<ProductEntity> productEntities1 = productRepository.findByProductPriceGreaterThan(5000);
        for (ProductEntity productEntity : productEntities1) {
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> productEntities2 = productRepository.findByProductPriceGreaterThanEqual(5000);
        for (ProductEntity productEntity : productEntities2) {
            System.out.println(productEntity.toString());
        }
    }

    @Test
    void containTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (ProductEntity productEntity : foundAll) {
            System.out.println(productEntity.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByProductNameContains("상품1"));
    }
    //endregion


    @Test
    public void basicCRUDTest() {
        ProductEntity productEntity = ProductEntity.builder()
            .productId("testProduct")
            .productName("testP")
            .productPrice(1000)
            .productStock(500)
            .build();
    }
    //endregion
}
