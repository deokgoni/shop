package jpastudy.shop.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
//Entity클래스들이 BaseTimeEntity을 상속할 경우 해당 변수도 칼럼으로 인식하도록
@MappedSuperclass
//Auditing기능 포함
@EntityListeners(AuditingEntityListener.class)
//모든 Entity의 상위 클래스가 되어 Entity들의 생성, 수정시간을 자동으로 관리하는 역할
public abstract class BaseTimeEntity{

    // Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
    @CreatedDate
    private LocalDateTime createdDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장됩니다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}