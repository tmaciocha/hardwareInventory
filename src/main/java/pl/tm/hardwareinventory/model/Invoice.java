package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;
import org.hibernate.dialect.MySQL8Dialect;
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

    //@NotBlank
    String filename;

    String description;

    //@NotBlank - walidacja
    Double netValue;

    String pathFile;

    @ManyToOne
    Company company;

    public String getNumberCompany(){
        return number + ", seller:  " + company.getName();
    }
    public String getNumberCompanyDateDescription(){
        return purchaseDate +",  " + number + ", " + company.getName()  +", " +  description;
    }



}
