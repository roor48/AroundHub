package study.min.aroundhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

import study.min.aroundhub.data.dto.ProductDto;
import study.min.aroundhub.data.entity.ProductEntity;
import study.min.aroundhub.data.handler.impl.ProductDataHandlerImpl;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@Import({ProductDataHandlerImpl.class, ProductServiceImpl.class})
public class ProductServiceImplTest {

    @MockBean
    ProductDataHandlerImpl productDataHandler;

    @Autowired
    ProductServiceImpl productService;

    @Test
    public void getProductTest() {
        //given
        Mockito.when(productDataHandler.getProductEntity("123")).thenReturn(
                new ProductEntity("123", "pen", 2000, 3000));

        ProductDto productDto = productService.getProduct("123");

        Assertions.assertEquals("123", productDto.getProductId(), "Id Test");
        Assertions.assertEquals("pen", productDto.getProductName(), "Name Test");
        Assertions.assertEquals("2000", Integer.toString(productDto.getProductPrice()), "Price Test");
        Assertions.assertEquals("3000", Integer.toString(productDto.getProductStock()), "Stock Test");

        verify(productDataHandler).getProductEntity("123");
    }

    @Test
    public void saveProductTest() {
        //given
        Mockito.when(productDataHandler.saveProductEntity("123", "pen", 2000, 3000))
                .thenReturn(new ProductEntity("123", "pen", 2000, 3000));

        ProductDto productDto = productService.saveProduct("123", "pen", 2000, 3000);

        Assertions.assertEquals("123", productDto.getProductId(), "Id Test");
        Assertions.assertEquals("pen", productDto.getProductName(), "Name Test");
        Assertions.assertEquals("2000", Integer.toString(productDto.getProductPrice()), "Price Test");
        Assertions.assertEquals("3000", Integer.toString(productDto.getProductStock()), "Stock Test");

        verify(productDataHandler).saveProductEntity("123", "pen", 2000, 3000);
    }
}
