package pl.tm.hardwareinventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.tm.hardwareinventory.repository.HardwareRepository;
import pl.tm.hardwareinventory.repository.SoftwareRepository;
import pl.tm.hardwareinventory.repository.TaskRepository;
import pl.tm.hardwareinventory.repository.UserRepository;

@SpringBootApplication
public class HardwareInventoryApplication {


    public static void main(String[] args) {
        SpringApplication.run(HardwareInventoryApplication.class, args);
    }

}
