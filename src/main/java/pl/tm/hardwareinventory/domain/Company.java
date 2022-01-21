package pl.tm.hardwareinventory.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.pl.NIP;

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
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String name;

    @NIP
    String nip;


    @ManyToMany
    List<Address> addresses=new ArrayList<>();

    @OneToMany
    List<User> users = new ArrayList<>();
}
