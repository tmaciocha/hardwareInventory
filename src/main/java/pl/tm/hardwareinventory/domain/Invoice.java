package pl.tm.hardwareinventory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

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

    //hardware
    //software
    //company
    //address


}
