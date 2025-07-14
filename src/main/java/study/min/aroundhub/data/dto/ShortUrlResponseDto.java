package study.min.aroundhub.data.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShortUrlResponseDto {
    private String orgUrl;
    private String shortUrl;
}
