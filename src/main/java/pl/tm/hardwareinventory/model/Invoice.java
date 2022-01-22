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
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String number;

    LocalDate purchaseDate;

    Double netValue;

    int vat;


    @OneToMany
    List<Hardware> hardwareList = new ArrayList<>();

    @OneToMany
    List<Software> softwareList = new ArrayList<>();

    @ManyToOne
    Company company;


}
