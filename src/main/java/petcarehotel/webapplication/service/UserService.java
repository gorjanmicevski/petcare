package petcarehotel.webapplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import petcarehotel.webapplication.models.enumerations.Role;
import petcarehotel.webapplication.models.User;

public interface UserService extends UserDetailsService {
  void addUser(User user);

  String register(User user);

  int enableUser(String email);

  User findById(Long id);

  User findByUsername(String username);
}
