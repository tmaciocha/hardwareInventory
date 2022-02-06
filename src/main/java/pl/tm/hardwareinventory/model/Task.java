package pl.tm.hardwareinventory.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String title;

    @Range(min = 1, max = 5)
    int priority; //1-5

    String description;

    Boolean status;

    LocalDate logDate;

    LocalDate closeDate;

    @ManyToOne
    Software software;

    @ManyToOne
    Hardware hardware;

    @ManyToOne
    User user;
}
