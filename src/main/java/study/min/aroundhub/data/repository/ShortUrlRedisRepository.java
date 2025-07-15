package study.min.aroundhub.data.repository;

import org.springframework.data.repository.CrudRepository;
import study.min.aroundhub.data.dto.ShortUrlResponseDto;

public interface ShortUrlRedisRepository extends CrudRepository<ShortUrlResponseDto, String> {

}
