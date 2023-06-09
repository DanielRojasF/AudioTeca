package com.AudioTeca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
      
    
      @Autowired
    private UserDetailsService userDetailsService;
 
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

     
    

//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("{noop}123")
//                .roles("USER", "ADMIN")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                .requestMatchers( 
                        "/", 
                        "/index",
                        "/errores/**",
                        "/error",
                        "/parte*", 
                        "/usuario/guardar",
                        "/webjars/**").permitAll()
                .requestMatchers(
                        "/libro/*.pdf*",
                        "/libro/nuevo",
                        "/libro/guardar",
                        "/libro/modificar/**",
                        "/libro/eliminar/**",
                        "/usuario/listado",
                        "/usuario/nuevo",
                        "/usuario/guardar",
                        "/usuario/modificar/**",
                        "/usuario/eliminar/**")
                .hasRole("ADMIN") 
                .requestMatchers(
                        "/",
                        "/index",
                        "/libro/listado",
                        "/libro/*.pdf*",
                        "/usuario/modificaPerfil/**",
                        "usuario/modificarPerfil/**")
                .hasAnyRole("ADMIN", "USER")
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling()
                .accessDeniedPage("/errores/403");
        return http.build();
    } 
           
}      
     