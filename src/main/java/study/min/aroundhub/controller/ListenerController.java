package study.min.aroundhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.min.aroundhub.data.entity.ListenerEntity;
import study.min.aroundhub.service.ListenerService;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    private final Logger LOGGER = LoggerFactory.getLogger(ListenerController.class);
    private final ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping
    public String getListener(Long id) {
        listenerService.getEntity(id);

        return "OK";
    }

    @PostMapping
    public void saveListener(String name) {
        LOGGER.info("[saveListener] 실행되었습니다.");
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setName(name);

        listenerService.saveEntity(listenerEntity);
    }

    @PutMapping
    public void updateListener(Long id, String name) {
        ListenerEntity listenerEntity = new ListenerEntity();
        listenerEntity.setId(id);
        listenerEntity.setName(name);

        listenerService.updateEntity(listenerEntity);
    }

    @DeleteMapping
    public void deleteListener(Long id) {
        ListenerEntity listenerEntity = listenerService.getEntity(id);

        listenerService.deleteEntity(listenerEntity);
    }
}
