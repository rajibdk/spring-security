package com.todo.configurations;

import com.todo.entity.TodoUser;
import com.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoCredentialProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TodoUser user = userRepository.findTodoUserByUsername(authentication.getName()).get(0);
        if(user != null && passwordEncoder.matches((String)authentication.getCredentials(), user.getPassword())) {
            List<GrantedAuthority> grants = List.of(new SimpleGrantedAuthority(user.getRole()));
            return new UsernamePasswordAuthenticationToken(authentication, authentication, grants);
        }

        throw new BadCredentialsException("Invalid User name or password!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
