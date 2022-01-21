package petcarehotel.webapplication.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import petcarehotel.webapplication.models.Role;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.models.exceptions.EmailAlreadyExistsException;
import petcarehotel.webapplication.models.exceptions.InvalidUsernameOrPasswordException;
import petcarehotel.webapplication.models.exceptions.PasswordsDoNotMatchException;
import petcarehotel.webapplication.models.exceptions.UsernameAlreadyExistsException;
import petcarehotel.webapplication.repository.UserRepository;
import petcarehotel.webapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void register(String username, String password, String repeatPassword,String email, String name, String surname, Role role) {
        //TODO implement
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        if(this.userRepository.findByEmail(email).isPresent())
            throw new EmailAlreadyExistsException(email);
        User user= new User(username,passwordEncoder.encode(password),email,name,surname,"0000");
        //return userRepository.save(user);
        userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsernameEqualsOrEmailEquals(username, username);
    }
}
