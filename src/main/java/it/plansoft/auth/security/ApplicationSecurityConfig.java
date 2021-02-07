package it.plansoft.auth.security;/* ggrosso created on 07/02/2021 inside the package - it.plansoft.auth.security */

import it.plansoft.auth.jwt.JwtConfig;
import it.plansoft.auth.jwt.JwtUserPasswordAuthFilter;
import it.plansoft.auth.jwt.JwtValidateTokenFilter;
import it.plansoft.auth.service.UserServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private UserServiceProvider uservice;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Autowired
    public ApplicationSecurityConfig(
            PasswordEncoder passwordEncoder,
            UserServiceProvider uservice,
            SecretKey secretKey,
            JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.uservice = uservice;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // STATELESS
                .and()
                .addFilter(new JwtUserPasswordAuthFilter(authenticationManager(), jwtConfig, secretKey))
                // registrazione del filtro di validazione del token dopo il filtro di autenticazione
                .addFilterAfter(new JwtValidateTokenFilter(jwtConfig, secretKey), JwtUserPasswordAuthFilter.class)
                .authorizeRequests()
                .anyRequest().authenticated()
        ;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uservice).passwordEncoder(passwordEncoder);
    }
}

