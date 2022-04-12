package petcarehotel.webapplication.web.controller;

import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import petcarehotel.webapplication.config.registration.RegistrationRequest;
import petcarehotel.webapplication.config.registration.RegistrationService;
import petcarehotel.webapplication.models.Review;
import petcarehotel.webapplication.models.User;
import petcarehotel.webapplication.models.enumerations.Role;
import petcarehotel.webapplication.service.PetService;
import petcarehotel.webapplication.service.ReviewService;
import petcarehotel.webapplication.service.UserService;

@Controller
@RequiredArgsConstructor
public class HomeController {
  private final UserService userService;
  private final PetService petService;
  private final ReviewService reviewService;
  private final RegistrationService registrationService;

  @GetMapping
  public String getHome(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "homepage");

    return "master-template";
  }

  @GetMapping("/gallery")
  public String getGalleryPage(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "gallery");
    return "master-template";
  }

  @GetMapping("/reviews")
  public String getReviews(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "reviews");
    model.addAttribute("reviews", reviewService.findAll());
    return "master-template";
  }

  private void userInSession(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList()).get(0).equals("ROLE_ANONYMOUS")) {
        model.addAttribute("currentUser", null);
      } else {
        model.addAttribute("currentUser", userService.findByUsername(authentication.getName()));
      }
    }
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
                           @RequestParam(required = false) Long userId) {
    User u = userService.findById(userId);
    reviewService.create(text, u, 5.0);
    return "redirect:/reviews";
  }

  @PostMapping("/reviews/{id}")
  public String updateReview(@PathVariable Long id,
                             @RequestParam(required = false) String text,
                             @RequestParam(required = false) Long userId) {
    User u = userService.findById(userId);
    reviewService.update(id, text, u);
    return "redirect:/reviews";
  }

  @PostMapping("/reviews/{id}/delete")
  public String deleteReview(@PathVariable Long id) {
    reviewService.delete(id);
    return "redirect:/reviews";
  }

  @GetMapping("/register")
  public String getRegisterPage(Model model) {
    model.addAttribute("bodyContent", "register");
    return "master-template";
  }

  @PostMapping("/registration")
  public String registerUser(@RequestParam String username,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String repeatPassword,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             Model model) {
    registrationService.register(
        new RegistrationRequest(username, firstName, lastName, email, password, repeatPassword,
            Role.ROLE_USER));
    model.addAttribute("bodyContent", "homepage");
    return "master-template";
  }

  @GetMapping("/registration/confirm")
  public String confirm(@RequestParam("token") String token, HttpServletResponse resp)
      throws IOException {
    return registrationService.confirmToken(token);
  }

  @GetMapping("/login")
  public String getLoginPage(Model model) {
    model.addAttribute("bodyContent", "login");
    return "master-template";
  }
}
