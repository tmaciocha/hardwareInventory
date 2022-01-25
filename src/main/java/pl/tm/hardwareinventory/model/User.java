package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Column(nullable = false, unique = true, length = 60)
    String username;//email

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotBlank
    String password;

    String domainUserName;

    String phoneNumber;

    boolean superUser;

    boolean activeUser;

    @Nullable
    //@NotBlank - wyrzuca validatorem
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate endOfContract;



    @ManyToMany
    List<Software> softwareList = new ArrayList<>();


    @ManyToMany(mappedBy = "users")
    List<Company> companies=new ArrayList<>();
}
