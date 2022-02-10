package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 30, message = "First name to short or to long")
    @Pattern(regexp = "^([^0-9]*)$", message = "First name cannot include numbers.")
    String firstName;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 2, max = 30, message = "Surname to short or to long")
    String lastName;

    @Column(nullable = false, unique = true, length = 60)
    @NotBlank(message = "Email is mandatory")
    @Email
    String username;//email

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotBlank(message = "Password is mandatory")
    String password;

    String domainUserName;

    String phoneNumber;

    boolean superUser;

    boolean activeUser;

    @Nullable
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Future
    LocalDate endOfContract;



    @ManyToMany
    @JoinTable(
            name = "users_software",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "software_id")})
    List<Software> softwareList = new ArrayList<>();

    @ManyToOne
    MyFile myFile;

    @OneToMany(mappedBy = "user")
    List<Task> taskList = new ArrayList<>();


}
