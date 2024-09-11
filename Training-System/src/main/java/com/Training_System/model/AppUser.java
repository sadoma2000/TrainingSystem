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

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String gender;



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
