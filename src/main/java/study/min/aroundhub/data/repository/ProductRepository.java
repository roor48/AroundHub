package study.min.aroundhub.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import study.min.aroundhub.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    /* 쿼리 메서드의 주제 키워드 */
    // 조회
    List<Product> findByName(String name);
    List<Product> queryByName(String name);

    // 존재 유무
    boolean existsByName(String name);

    // 쿼리 결과 개수
    long countByName(String name);

    // 삭제
    void deleteById(String id);
    long removeById(String id);

    // 값 개수 제한
    List<Product> findFirst5ByName(String name);
    List<Product> findTop3ByName(String name);

    /* 쿼리 메서드의 조건자 키워드 */

    // Is, Equals (생략 가능)
    // Logical Keyword: IS, Keyword Expressions: Is, Equals, (or no keyword)
    // findByNumber 메서드와 동일하게 동작
    Product findByIdIs(String id);
    Product findByIdEquals(String id);

    // (Is)Not
    List<Product> findByIdNot(String id);
    List<Product> findByIdIsNot(String id);

    // (Is)Null, (Is)NotNull
    List<Product> findByStockIsNull();
    List<Product> findByStockIsNotNull();

    // And, Or
    List<Product> findTopByIdAndName(String id, String name);

    // (Is)GreaterThan, (Is)LessThan, (Is)Between
    List<Product> findByPriceGreaterThan(Integer price);
    List<Product> findByPriceGreaterThanEqual(Integer price);

    // (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith
    List<Product> findByNameContains(String name);
}
