package petcarehotel.webapplication.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import petcarehotel.webapplication.config.registration.RegistrationRequest;
import petcarehotel.webapplication.config.registration.RegistrationService;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.models.enumerations.Role;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.ReviewService;
import petcarehotel.webapplication.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    private final UserService userService;
    private final PetService petService;
    private final ReviewService reviewService;
    private final RegistrationService registrationService;
    public HomeController(UserService userService, PetService petService, ReviewService reviewService, RegistrationService registrationService) {
        this.userService = userService;
        this.petService = petService;
        this.reviewService = reviewService;
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

    @GetMapping("/reviews/add")
    public String showAdd(Model model) {
        model.addAttribute("bodyContent", "add-review");
        return "master-template";
    }

    @GetMapping("/reviews/{id}/edit")
    public String showEdit(@PathVariable Long id,
                           Model model) {
        Review r = reviewService.findById(id);
        model.addAttribute("review", r);
        model.addAttribute("bodyContent", "add-review");
        return "master-template";
    }


    @PostMapping("/reviews")
    public String postReview(@RequestParam(required = false) String text,
                             @RequestParam(required = false) Long userId){
        User u = userService.findById(userId);
        reviewService.create(text, u);
        return "redirect:/reviews";
    }

    @PostMapping("/reviews/{id}")
    public String updateReview(@PathVariable Long id,
                               @RequestParam(required = false) String text,
                               @RequestParam(required = false) Long userId){
        User u = userService.findById(userId);
        reviewService.update(id, text, u);
        return "redirect:/reviews";
    }

    @PostMapping("/reviews/{id}/delete")
    public String deleteReview(@PathVariable Long id){
        reviewService.delete(id);
        return "redirect:/reviews";
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
