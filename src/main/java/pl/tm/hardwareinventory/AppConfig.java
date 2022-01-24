package pl.tm.hardwareinventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.tm.hardwareinventory.converter.UserConverter;

@Configuration
@ComponentScan("pl.tm")
@EnableTransactionManagement //do spring data w ramach spring boota
@EnableJpaRepositories(basePackages = "pl.tm.hardwareinventory.repository")//do spring data w ramach spring boota  ---- Interfejsy z repozytoriami
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("admin/login");
        registry.addViewController("/403").setViewName("403");
    }


    @Bean
    public UserConverter userConverter(){return new UserConverter();}

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(userConverter());
    }



}
