package study.min.aroundhub.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MinUriDto {

    private String message;
    private String code;
    private Result result;

    @Getter
    @Setter
    @ToString
    public static class Result {
        private String hash;
        private String url;
        private String origin;
    }
}
