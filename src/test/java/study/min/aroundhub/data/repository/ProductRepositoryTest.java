package study.min.aroundhub.data.repository;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;
import study.min.aroundhub.data.entity.Product;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void GenerateData() {
        productRepository.save(getProduct(Integer.toString(1), 1, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(2), 2, 3000, 9000));
        productRepository.save(getProduct(Integer.toString(2), 4, 1500, 200));
        productRepository.save(getProduct(Integer.toString(4), 4, 4000, 3000));
        productRepository.save(getProduct(Integer.toString(5), 5, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(6), 6, 10000, 1000));
        productRepository.save(getProduct(Integer.toString(7), 7, 500, 10000));
        productRepository.save(getProduct(Integer.toString(8), 8, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(9), 9, 1000, 2000));
        productRepository.save(getProduct(Integer.toString(10), 10, 5100, 1700));
    }

    private Product getProduct(String id, int nameNumber, int price, int stock) {
        return new Product(id, "상품" + nameNumber, price, stock);
    }

    //region **주제 키워드 테스트**
    @Test
    void findTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }

        System.out.println("========== Test Data End ==========");

        List<Product> foundEntities = productRepository.findByName("상품4");

        for (Product product : foundEntities) {
            System.out.println(product.toString());
        }

        List<Product> queryEntities = productRepository.queryByName("상품4");

        for (Product product : queryEntities) {
            System.out.println(product.toString());
        }
    }

    @Test
    void existText() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.existsByName("상품4"));
        System.out.println(productRepository.existsByName("상품2"));
        System.out.println(productRepository.existsByName("상품3"));
    }

    @Test
    void countTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.countByName("상품4"));
    }

    @Test
    @Transactional
    void deleteTest() {
        System.out.println("Before : " + productRepository.count());

        productRepository.deleteById("1");
        productRepository.deleteById("9");

        System.out.println("After delete : " + productRepository.count());

        long response = productRepository.removeById("4");

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

        List<Product> foundEntities1 = productRepository.findFirst5ByName("상품123");
        for (Product product : foundEntities1) {
            System.out.println(product.toString());
        }

        List<Product> foundEntities2 = productRepository.findTop3ByName("상품123");
        for (Product product : foundEntities2) {
            System.out.println(product.toString());
        }
    }
    //endregion

    //region **조건자 키워드 테스트**
    @Test
    void isEqualsTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByIdIs("1"));
        System.out.println(productRepository.findByIdEquals("9"));
    }

    @Test
    void notTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<Product> foundEntities1 = productRepository.findByIdNot("1");
        for (Product product : foundEntities1) {
            System.out.println(product.toString());
        }

        List<Product> foundEntities2 = productRepository.findByIdIsNot("1");
        for (Product product : foundEntities2) {
            System.out.println(product.toString());
        }
    }

    @Test
    void nullTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByStockIsNull());
        System.out.println(productRepository.findByStockIsNotNull());
    }

    @Test
    void andTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findTopByIdAndName("1", "상품1"));
    }

    @Test
    void greaterTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        productRepository.save(getProduct("100", 123, 5000, 5000));
        productRepository.save(getProduct("101", 123, 5001, 5000));

        List<Product> productEntities1 = productRepository.findByPriceGreaterThan(5000);
        for (Product product : productEntities1) {
            System.out.println(product.toString());
        }

        List<Product> productEntities2 = productRepository.findByPriceGreaterThanEqual(5000);
        for (Product product : productEntities2) {
            System.out.println(product.toString());
        }
    }

    @Test
    void containTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        System.out.println(productRepository.findByNameContains("상품1"));
    }
    //endregion

    //region **정렬과 페이징 테스트**
    @Test
    void orderByTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<Product> foundProducts = productRepository.findByNameContainingOrderByStockAsc("상품");
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }
        
        foundProducts = productRepository.findByNameContainingOrderByStockDesc("상품");
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }

        foundProducts = productRepository.findFirst5ByNameContainingOrderByStockAsc("상품");
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }
    }

    @Test
    void multiOrderByTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<Product> foundProducts = productRepository.findByNameContainingOrderByPriceAscStockDesc("상품");
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }
    }

    @Test
    void orderByWithParameterTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<Product> foundProducts = productRepository.findByNameContaining(
            "상품",
            Sort.by(Order.asc("price"))
        );
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }

        foundProducts = productRepository.findByNameContaining(
            "상품",
            Sort.by(Order.asc("price"), Order.asc("stock"))
        );
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }
    }

    @Test
    void pagingTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("========== Test Data Start ==========");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("========== Test Data End ==========");

        List<Product> foundProducts = productRepository.findByPriceGreaterThan(
            200,
            PageRequest.of(0, 2)
        );
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }

        foundProducts = productRepository.findByPriceGreaterThan(
            200,
            PageRequest.of(4, 2)
        );
        for (Product product : foundProducts) {
            System.out.println(product.toString());
        }
    }
    //endregion

    @Test
    public void basicCRUDTest() {
        Product product = Product.builder()
            .id("testProduct")
            .name("testP")
            .price(1000)
            .stock(500)
            .build();
    }
    //endregion
}
