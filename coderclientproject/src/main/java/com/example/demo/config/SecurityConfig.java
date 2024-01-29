package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/addAdmin", "/editAdmin", "/deleteadmin")
            .hasRole("ADMIN")           
            .authorizeRequests()
            .antMatchers("/teacher/**").hasRole("TEACHER")
            .antMatchers("/student/**").hasRole("STUDENT")
                .antMatchers("/api/public").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }

    //@Override
    //protected void configure(AuthanticationManagerBuilder auth) throws Exception {
    //auth.inMemoryAuthantication().withUser(username:"john").password(this.passwordEncoder().encode("durgesh")).roles("NORMAL");
    //auth.inMemoryAuthantication().withUser(username:"rajneesh").password(this.passwordEncoder().encode("abc")).roles("ADMIN");
    //
    
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
        
        
     
    }
}

