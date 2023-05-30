package com.jo.picPublising.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jo.picPublising.persistance.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
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

        List<GrantedAuthority>  authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());

        return new UserDetailsImpl(user.getId(), user.getUserName(),user.getEmail(),user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}