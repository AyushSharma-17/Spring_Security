package com.example.spscrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       return http
               .csrf(customizer-> customizer.disable())
               .authorizeHttpRequests(request->request.anyRequest().authenticated())
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();
   }
        //http.formLogin(Customizer.withDefaults());  this is used to disable the form login and let access throught the postman

    // @Bean
    // public UserDetailsService userDetailsService(){

    //     UserDetails user1= User
    //             .withDefaultPasswordEncoder()  // method depicateds
    //             .username("ayush")
    //             .password("ayush@123")
    //             .roles("USER")
    //             .build();
    //     return new InMemoryUserDetailsManager(user1);
    // }

    // @Bean
    // public AuthenticationProvider authenticationProvider(){
    //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    //     provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    //     provider.setUserDetailsService(userDetailsService);
    //     return provider;
    // }

// @Bean
// public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
//                                                      PasswordEncoder passwordEncoder) {
//     DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
//     provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//     return provider;
// }
@Autowired
 UserDetailsService userDetailsService;

    // public SecurityConfig(UserDetailsService userDetailsService) {
    //     this.userDetailsService = userDetailsService;
    // }


@Bean
public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // for testing only
     provider.setUserDetailsService(userDetailsService);
    return provider;
}

@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

   
}
