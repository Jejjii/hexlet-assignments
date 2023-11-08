package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Date;

// BEGIN
@Entity
@Table(name = "tasks")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String title;

    private String description;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private Date updatedAt;

}
// END
