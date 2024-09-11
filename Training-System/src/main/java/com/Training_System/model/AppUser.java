package com.Training_System.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(10) NOT NULL UNIQUE")
    private String username;

    @Column(columnDefinition = "VARCHAR(300) NOT NULL")
    private String password;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String gender;



    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String role;


    //RELATIONS (ADD TO THE OTHER TWO CLASSES)
    @OneToOne( mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private Student student;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private Instructor instructor;


    //USER DETAIL METHODS

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
