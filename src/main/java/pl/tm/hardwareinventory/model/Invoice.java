package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate purchaseDate;

    String filename;

    String description;

    Double netValue;

    @ManyToOne
    Company company;

    public String getNumberCompany(){
        return "Nr " + number + ", FROM:  " + company.getName();
    }
    public String getNumberCompanyDateDescription(){
        return purchaseDate +", Nr " + number + ", " + company.getName()  +", " +  description;
    }


}
