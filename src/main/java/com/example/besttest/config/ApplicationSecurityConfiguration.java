//package com.example.besttest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.context.DelegatingSecurityContextRepository;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
//import org.springframework.security.web.context.SecurityContextRepository;
//
//@EnableWebSecurity
//@Configuration
//public class ApplicationSecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http, SecurityContextRepository securityContextRepository) throws Exception {
//        http
//                .authorizeHttpRequests(
//                        authorizeHttpRequests ->
//                                authorizeHttpRequests
//                                        .requestMatchers("/**").permitAll() // Разрешить доступ к публичным страницам
//                                        .anyRequest().authenticated()
//                )
//                .formLogin(
//                        (formLogin) ->
//                                formLogin.
//                                        loginPage("/sign/in").
//                                        usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
//                                        passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
//                                        defaultSuccessUrl("/home",true).
//                                        failureForwardUrl("/sign/in/error")
//                )
//                .logout((logout) ->
//                        logout.logoutUrl("/sign/out").
//                                logoutSuccessUrl("/home").
//                                invalidateHttpSession(true)
//                ).securityContext(
//                        securityContext -> securityContext.
//                                securityContextRepository(securityContextRepository)
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public SecurityContextRepository securityContextRepository() {
//        return new DelegatingSecurityContextRepository(
//                new RequestAttributeSecurityContextRepository(),
//                new HttpSessionSecurityContextRepository()
//        );
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
