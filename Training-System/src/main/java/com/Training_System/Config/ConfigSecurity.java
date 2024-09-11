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
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and() //Authorization
                .authenticationProvider(daoAuthenticationProvider())
                .authorizeHttpRequests()
                .requestMatchers("/api/students/register",
                        "/api/Instructors/register",
                        "/api/admin/register-admin").permitAll() // Allowed for ALL
                .requestMatchers(
                        "/api/certificates",
                        "/api/enrollments/delete/{id}",
                        "/api/enrollments/add/{studentId}/{courseId}",
                        "/api/Course/get-all",
                        "/api/certificates/get-by-student/{studentId}")
                .hasAuthority("STUDENT")
                .requestMatchers(
                        "/api/certificates/get-by-student/{studentId}",
                        "/api/Course/update/{id}",
                        "/api/lessons/update/{lessonId}"
                )
                .hasAuthority("INSTRUCTOR")
                .requestMatchers(
                        "/api/Instructors/get-all",
                        "/api/progress/get-all",
                        "/api/enrollments/get-all")
                .hasAuthority("ADMIN")

                .requestMatchers(
                        "/api/students/get-all",
                        "/api/Course/get-all",
                        "/api/lessons/get-all",
                        "/api/certificates/get-all",
                        "/api/reviews/get-all")
                .hasAnyAuthority("ADMIN", "INSTRUCTOR")

                //.requestMatchers("/**").hasAuthority("Admin") // Admins can access everything
                .and() //logout
                .logout().logoutUrl("/api/v1/auth/logout").logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }
}
