package petcarehotel.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
