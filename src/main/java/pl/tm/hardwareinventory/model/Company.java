package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
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

   // @NotBlank
    String name;

   @NIP
    @Column(unique = true)
    String nip;

   // @NotBlank
    String street;

    //@NotBlank
    @Column(name = "streetnumber")
    String streetNumber;

    String postCode;

  // @NotNull
    String city;

    String description;

    public String getNipName() {
        return nip + ", " + name;
    }

    @OneToMany(mappedBy = "company")//, cascade = CascadeType.ALL)
    private Collection<Invoice> invoice;


    public Collection<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(Collection<Invoice> invoice) {
        this.invoice = invoice;
    }
}
