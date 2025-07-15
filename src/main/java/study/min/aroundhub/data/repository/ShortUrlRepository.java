package study.min.aroundhub.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.min.aroundhub.data.entity.ShortUrlEntity;

public interface ShortUrlRepository extends JpaRepository<ShortUrlEntity, Long> {

    ShortUrlEntity findByUrl(String url);

    ShortUrlEntity findByOrgUrl(String orgUrl);
}
