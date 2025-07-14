package study.min.aroundhub.data.dao;

import study.min.aroundhub.data.entity.ShortUrlEntity;

public interface ShortUrlDao {
    void saveShortUrl(ShortUrlEntity shortUrlEntity);

    ShortUrlEntity getShortUrl(String originalUrl);
}
