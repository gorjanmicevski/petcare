package petcarehotel.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.UserService;

@Controller
@RequestMapping({"/petcare","/"})
public class HomeController {
    private final UserService userService;
    private final PetService petService;

    public HomeController(UserService userService, PetService petService) {
        this.userService = userService;
        this.petService = petService;
    }

    @GetMapping
    public String getHome(){
        return "homepage";
    }
}
