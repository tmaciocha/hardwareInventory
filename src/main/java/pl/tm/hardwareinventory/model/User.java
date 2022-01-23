package pl.tm.hardwareinventory.model;

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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    String firstName;

    @NotBlank
    String lastName;

    @NotBlank
    String email;

    @NotBlank
    String password;

    String domainUserName;

    String phoneNumber;

    boolean superUser;



    @ManyToMany
    List<Software> softwareList = new ArrayList<>();


    @ManyToMany(mappedBy = "users")
    List<Company> companies=new ArrayList<>();
}
