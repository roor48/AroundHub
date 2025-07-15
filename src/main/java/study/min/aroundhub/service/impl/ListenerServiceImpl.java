package study.min.aroundhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.min.aroundhub.data.entity.ListenerEntity;
import study.min.aroundhub.data.repository.ListenerRepository;
import study.min.aroundhub.service.ListenerService;

@Service
public class ListenerServiceImpl implements ListenerService {

    private final ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }


    @Override
    public ListenerEntity getEntity(Long id) {
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(ListenerEntity listenerEntity) {
        listenerRepository.save(listenerEntity);
    }

    @Override
    public void updateEntity(ListenerEntity listenerEntity) {
        ListenerEntity foundEntity = listenerRepository.findById(listenerEntity.getId()).get();
        foundEntity.setName(listenerEntity.getName());

        listenerRepository.save(foundEntity);
    }

    @Override
    public void deleteEntity(ListenerEntity listenerEntity) {
        listenerRepository.delete(listenerEntity);
    }
}
