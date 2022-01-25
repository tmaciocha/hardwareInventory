package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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

    String inventoryNumber;

    String screenSize;

    int ramAmount;

    int discSize;

    String discType;

    LocalDate purchaseDate;

    LocalDate productionDate;

    LocalDate logDate;

    String batteryQuality;

    String description;

    Double netPrice;

    @OneToOne
    Producer producer;

    @OneToOne
    HardwareType hardwareType;

    @OneToOne
    HardwareQuality hardwareQuality;



    @ManyToMany
    List<Software> softwareList = new ArrayList<>();

    @ManyToOne
    Company company;

    @OneToOne
    Invoice invoice;

    @OneToOne
    User user;
}
