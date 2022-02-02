package pl.tm.hardwareinventory;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.tm.hardwareinventory.converter.CompanyConverter;
import pl.tm.hardwareinventory.converter.UserConverter;

import javax.validation.Validator;

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

    @Bean
    public CompanyConverter companyConverter(){return new CompanyConverter();}

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(userConverter());
        registry.addConverter(companyConverter());
    }

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){return  new CommonsMultipartResolver();}

}
