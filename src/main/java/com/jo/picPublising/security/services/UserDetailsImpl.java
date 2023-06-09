package com.jo.picPublising.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jo.picPublising.persistance.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private Long id;

    private String userName;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String userName,String email, String password, Collection<? extends GrantedAuthority> authorities){
            this.id=id;
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.authorities = authorities;
    }
    public static UserDetailsImpl build(User user){

        Set<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toSet());
        UserDetailsImpl userDetails = new UserDetailsImpl(user.getId(), user.getUserName(),user.getEmail(),user.getPassword(), authorities);

        return userDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
