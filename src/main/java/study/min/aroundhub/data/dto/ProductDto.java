package study.min.aroundhub.data.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import study.min.aroundhub.data.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

    @NotNull
//    @Size(min = 8, max = 8)
    private String productId;

    @NotNull
    private String productName;

    @NotNull
    @Min(500)
    @Max(30000000)
    private int productPrice;

    @NotNull
    @Min(0)
    @Max(9999)
    private int productStock;

    public Product toEntity() {
        return Product.builder()
                .id(productId)
                .name(productName)
                .price(productPrice)
                .stock(productStock)
                .build();
    }
}
