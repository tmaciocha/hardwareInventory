package pl.tm.hardwareinventory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "software")
public class Software {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String name;

    String version;

    String manual;

    String homePage;

    String description;

    @OneToMany
    List<Task> tasks = new ArrayList<>();

    @OneToOne
    SoftwareType softwareType;

    @OneToOne
    Producer producer;

    @OneToOne
    Invoice invoice;

    @ManyToMany(mappedBy = "softwareList")
    List<Hardware>hardwareList=new ArrayList<>();
}
