package study.min.aroundhub.data.entity;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class BaseEntity {

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
