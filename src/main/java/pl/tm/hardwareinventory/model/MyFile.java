package pl.tm.hardwareinventory.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "files")
public class MyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String filename;
    String pathFile;

    public MyFile(String filename, String pathFile) {
        this.filename = filename;
        this.pathFile = pathFile;
    }

    public String pathWithFileName(){
        return pathFile+"/"+filename;
    }

    @OneToOne
    Invoice invoice;
}
