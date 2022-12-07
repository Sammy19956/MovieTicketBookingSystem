package com.example.movieticketbookingsystem.infrastructure.configuration.Security;

import com.example.movieticketbookingsystem.domain.entities.Enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority("ROLE_USER")
                .and()
                .formLogin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
      UserDetails user = User.builder()
              .username("username")
              .password(PasswordConfiguration.passwordEncoder().encode("password"))
              .authorities(UserRole.USER.getGrantedAuthority())
              .roles("USER")
              .build();
      return new InMemoryUserDetailsManager(user);
    }
}
