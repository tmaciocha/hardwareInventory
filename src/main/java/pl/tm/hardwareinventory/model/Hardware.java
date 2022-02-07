package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "hardware")
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String name;

    @NotBlank
    @Column(unique = true)
    String serialNumber;

    String macNumber;

    int screenSize;

    int ramAmount;

    int discSize;

    String discType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    LocalDate productionDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate LastChangeDate;

    String batteryQuality;

    String description;

    Double netPrice;

    Boolean usable;

    Boolean inUse;

    @OneToOne
    Producer producer;

    @OneToOne
    HardwareType hardwareType;

    @OneToOne
    HardwareQuality hardwareQuality;


    @ManyToMany
    @JoinTable(
            name = "hardware_software",
            joinColumns = {@JoinColumn(name = "hardware_id")},
            inverseJoinColumns = {@JoinColumn(name = "software_id")})
    List<Software> softwareList = new ArrayList<>();

    @ManyToOne
    Company company;

    @OneToOne
    Invoice invoice;

    @OneToOne
    User user;

    @OneToMany (mappedBy = "hardware")
    List<Task> taskList = new ArrayList<>();

    @ManyToOne
    MyFile myFile;
}
