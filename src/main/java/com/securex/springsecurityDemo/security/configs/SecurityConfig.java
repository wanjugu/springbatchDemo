package com.securex.springsecurityDemo.security.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( (requests)-> requests
                .requestMatchers("/myAccount", "/myBalance", "myLoans", "myCards").authenticated()
                .requestMatchers("/notices", "contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /*
    * InMemoryUserDetailsManager -- Demo ---  not recommended for Production.
    * */


    //Approach-1
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//
//    }

    //Approach2 - we create a bean of PasswordEncoder Seperately
    @Bean
    public InMemoryUserDetailsManager userDetailsService(){

        UserDetails admin = User.withUsername("admin")
            .password("123456")
            .authorities("admin")
            .build();

        UserDetails user = User.withUsername("user")
            .password("123456")
            .authorities("read")
            .build();

        return new InMemoryUserDetailsManager(admin,user);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
