package petcarehotel.webapplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import petcarehotel.webapplication.models.Role;
import petcarehotel.webapplication.models.User;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
