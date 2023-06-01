package com.jo.picPublising.security.services;

import com.jo.picPublising.business.mapping.CustomUserMapper;
import com.jo.picPublising.exception.ObjectNotFoundException;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.security.services.UserDetailsImpl;
import com.jo.picPublising.persistance.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmail(username).orElseThrow(() -> new ObjectNotFoundException("User Not Found"));

        return UserDetailsImpl.build(user);
    }
}
