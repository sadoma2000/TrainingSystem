package com.Training_System.Config;

import com.Training_System.service.impl.MyUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigSecurity {

    private final MyUserDetailService myUserDetailService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/v1/auth/**").permitAll() // Allowed for ALL
                        .requestMatchers(
                                "/api/certificates",
                                "/api/enrollments/delete/{id}",
                                "/api/enrollments/add/{studentId}/{courseId}",
                                "/api/Course/get-all",
                                "/api/certificates/get-by-student/{studentId}")
                        .hasAuthority("Student")
                        .requestMatchers(
                                "/api/certificates/get-by-student/{studentId}",
                                "/api/certificates/get-all",
                                "/api/Course/get-all",
                                "/api/Course/update/{id}",
                                "/api/lessons/get-all",
                                "/api/lessons/update/{lessonId}",
                                "/api/reviews/get-all",
                                "/api/students/get-all")
                        .hasAuthority("Instructor")
                        .requestMatchers(
                                "/api/v1/Instructors/get-all",
                                "/api/students/get-all",
                                "/api/Course/get-all",
                                "/api/lessons/get-all",
                                "/api/progress/get-all",
                                "/api/certificates/get-all",
                                "/api/reviews/get-all",
                                "/api/enrollments/get-all")
                        .hasAuthority("ADMIN")
                        .requestMatchers("/**").hasAuthority("Admin") // Admins can access everything
                )
                .logout(logout -> logout
                        .logoutUrl("/api/v1/auth/logout")
                        .logoutSuccessUrl("/")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true)
                )
                .httpBasic();
        return http.build();
    }
}
