package study.min.aroundhub.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import study.min.aroundhub.data.dto.ProductDto;
import study.min.aroundhub.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductServiceImpl productService;

//    @Autowired
//    public ProductControllerTest(MockMvc mockMvc) {
//        this.mockMvc = mockMvc;
//    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @Test
    @DisplayName("Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {
        String productId = "12315";
        // given: Mock 객체가 특정 상황에서 해야하는 행위를 정의하는 메서드
        given(productService.getProduct(productId)).willReturn(new ProductDto("15871", "pen", 5000, 2000));

        // andExpect: 기대하는 값이 나왔는지 체크해볼 수 있는 메서드
        mockMvc.perform(
                get("/api/v1/product-api/product/" + productId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.productId").exists())
            .andExpect(jsonPath("$.productName").exists())
            .andExpect(jsonPath("$.productPrice").exists())
            .andExpect(jsonPath("$.productStock").exists())
            .andDo(print());

        // verify: 해당 객체의 메서드가 실행되었는지 체크
        verify(productService).getProduct(productId);
    }


    @Test
    @DisplayName("Product 데이터 생성 테스트")
    void createProductTest() throws Exception {
        //Mock 객체에서 특정 메서드가 실행되는 경우 실제 return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만듦
        given(productService.saveProduct("1111", "pen", 5000, 2000)).willReturn(
                new ProductDto("1111", "pen", 5000, 2000));

        ProductDto productDto = ProductDto.builder().productId("1111").productName("pen")
                .productPrice(5000).productStock(2000).build();

        Gson gson = new Gson();
        // 아래 둘 중 하나로 대체 가능
        String content = gson.toJson(productDto);
//        String content = new ObjectMapper().writeValueAsString(productDto);



        mockMvc.perform(post("/api/v1/product-api/product")
                    .content(content)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productName").exists())
                .andExpect(jsonPath("$.productPrice").exists())
                .andExpect(jsonPath("$.productStock").exists())
                .andDo(print());

        verify(productService).saveProduct("1111", "pen", 5000, 2000);
    }

}
