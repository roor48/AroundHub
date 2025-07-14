package study.min.aroundhub.data.dao.impl;

import org.springframework.stereotype.Service;
import study.min.aroundhub.data.dao.ShortUrlDao;
import study.min.aroundhub.data.entity.ShortUrlEntity;

@Service
public class ShortUrlDaoImpl implements ShortUrlDao {

    @Override
    public void saveShortUrl(ShortUrlEntity shortUrlEntity) {

    }

    @Override
    public ShortUrlEntity getShortUrl(String originalUrl) {
        return null;
    }
}
