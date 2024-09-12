package com.employeecrud.securityconfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
//
//@Configuration
//@EnableMethodSecurity
public class SecConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, active from users where username= ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, role from roles where username= ?");
        return jdbcUserDetailsManager;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(request -> request
//                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
//                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
        http.authorizeHttpRequests(req -> req.anyRequest().authenticated());

//        http.sessionManagement(
//                session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


}
