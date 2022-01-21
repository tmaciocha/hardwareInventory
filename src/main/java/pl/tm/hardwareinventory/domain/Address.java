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
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String street;

    @NotBlank
    String number;

    String postCode;

    @NotBlank
    String city;

    String description;


    @ManyToMany (mappedBy = "addresses")
    List<Company> companies=new ArrayList<>();
}
