package petcarehotel.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petcarehotel.webapplication.config.registration.RegistrationRequest;
import petcarehotel.webapplication.config.registration.RegistrationService;
import petcarehotel.webapplication.models.enumerations.Role;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping({"/petcare","/"})
public class HomeController {
    private final UserService userService;
    private final PetService petService;
    private final RegistrationService registrationService;
    public HomeController(UserService userService, PetService petService, RegistrationService registrationService) {
        this.userService = userService;
        this.petService = petService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getHome(Model model){
        model.addAttribute("bodyContent","homepage");
        return "master-template";
    }
    @GetMapping("/gallery")
    public String getGalleryPage(Model model){
        model.addAttribute("bodyContent","gallery");
        return "master-template";
    }
    @GetMapping("/reviews")
    public String getReviews(Model model){
        model.addAttribute("bodyContent","reviews");
        return "master-template";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("bodyContent","register");
        return "master-template";
    }
    @PostMapping("/registration")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String repeatPassword,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               Model model){
        registrationService.register(new RegistrationRequest(username,firstName,lastName,email,password,repeatPassword, Role.ROLE_USER));
        model.addAttribute("bodyContent","homepage");
        return "master-template";
    }
    @GetMapping("/registration/confirm")
    public String confirm(@RequestParam("token") String token, HttpServletResponse resp) throws IOException {
        return registrationService.confirmToken(token);
    }
}
