package pl.tm.hardwareinventory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("pl.tm")
@EnableTransactionManagement //do spring data w ramach spring boota
@EnableJpaRepositories(basePackages = "pl.tm.hardwareinventory.repository")//do spring data w ramach spring boota  ---- Interfejsy z repozytoriami
public class AppConfig {


}
