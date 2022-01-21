package petcarehotel.webapplication.config.registration;


import petcarehotel.webapplication.models.enumerations.Role;

public class RegistrationRequest {
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String repeatPassword;
    private final Role role;

    public RegistrationRequest(String username, String firstName, String lastName, String email, String password, String repeatPassword, Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
    }
    public String getRepeatPassword() {
        return repeatPassword;
    }
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}