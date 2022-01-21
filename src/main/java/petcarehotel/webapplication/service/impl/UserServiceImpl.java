package petcarehotel.webapplication.service.impl;

import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import petcarehotel.webapplication.config.token.ConfirmationToken;
import petcarehotel.webapplication.config.token.ConfirmationTokenService;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.repository.UserRepository;
import petcarehotel.webapplication.service.UserService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService tokenService;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ConfirmationTokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String register(User appUser) {
        //TODO implement

        String encodedPass = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPass);
        userRepository.save(appUser);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        tokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    @Override
    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsernameEqualsOrEmailEquals(username, username);
    }
}
