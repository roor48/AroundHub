package study.min.aroundhub.data.dao;

import study.min.aroundhub.data.entity.ShortUrlEntity;

public interface ShortUrlDao {
    ShortUrlEntity saveShortUrl(ShortUrlEntity shortUrlEntity);

    ShortUrlEntity getShortUrl(String originalUrl);

    ShortUrlEntity getOriginalUrl(String shortUrl);

    ShortUrlEntity updateShortUrl(ShortUrlEntity newShortUrlEntity);

    void deleteByShortUrl(String shortUrl);

    void deleteByOriginalUrl(String originalUrl);
}
