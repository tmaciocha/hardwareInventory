package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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

    Double netPrice;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate logDate;

    String description;

    String serialKey;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate activeUpTo;

    boolean active;


    @OneToOne
    SoftwareType softwareType;


    @OneToOne
    Invoice invoice;

    @ManyToMany(mappedBy = "softwareList")
    List<Hardware>hardwareList=new ArrayList<>();


    @ManyToMany(mappedBy = "softwareList")
    List<User> users=new ArrayList<>();

    @ManyToOne
    Company company;


    @OneToOne
    Producer producer;

    @ManyToOne
    MyFile myFile;
}
