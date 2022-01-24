package pl.tm.hardwareinventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.service.SpringDataUserDetailsService;
import pl.tm.hardwareinventory.service.UserService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
//dzięki temu możemy w kontrolerach dodawać np: @Secured("ROLE_ADMIN")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(springDataUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/about").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/hardware/**").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and().logout().logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
        http.cors().disable();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService springDataUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

  }
