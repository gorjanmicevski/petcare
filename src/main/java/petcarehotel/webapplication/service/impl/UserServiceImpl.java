package petcarehotel.webapplication.service.impl;

import org.springframework.stereotype.Service;
import petcarehotel.webapplication.repository.UserRepository;
import petcarehotel.webapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
