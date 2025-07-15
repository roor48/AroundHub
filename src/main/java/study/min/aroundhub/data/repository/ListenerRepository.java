package study.min.aroundhub.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.min.aroundhub.data.entity.ListenerEntity;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {

}
