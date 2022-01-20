package petcarehotel.webapplication.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import petcarehotel.webapplication.models.Pet;
import petcarehotel.webapplication.models.Role;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.repository.UserRepository;
import petcarehotel.webapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        //TODO implement
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
