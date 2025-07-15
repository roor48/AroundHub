package study.min.aroundhub.service;

import study.min.aroundhub.data.entity.ListenerEntity;

public interface ListenerService {
    ListenerEntity getEntity(Long id);
    void saveEntity(ListenerEntity listenerEntity);
    void updateEntity(ListenerEntity listenerEntity);
    void deleteEntity(ListenerEntity listenerEntity);
}
