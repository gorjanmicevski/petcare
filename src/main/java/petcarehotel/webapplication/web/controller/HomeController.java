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

/**
 * Home controller.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
  private final UserService userService;
  private final PetService petService;
  private final ReviewService reviewService;
  private final RegistrationService registrationService;

  /**
   * Method to return getHome.
   *
   * @param model Model
   * @return String
   */
  @GetMapping
  public String getHome(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "homepage");

    return "master-template";
  }

  /**
   * Method to return getGalleryPage.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/gallery")
  public String getGalleryPage(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "gallery");
    return "master-template";
  }

  /**
   * Method to return getReviews.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/reviews")
  public String getReviews(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "reviews");
    model.addAttribute("reviews", reviewService.findAll());
    return "master-template";
  }

  /**
   * Method to find the userInSession.
   *
   * @param model Model
   */
  private User userInSession(Model model) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User userInSession=null;
    if (authentication != null) {
      if (authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
          .collect(Collectors.toList()).get(0).equals("ROLE_ANONYMOUS")) {
        model.addAttribute("currentUser", null);
      } else {
        userInSession=userService.findByUsername(authentication.getName());
        model.addAttribute("currentUser", userInSession);
      }
    }
    return userInSession;
  }

  /**
   * Method to add a review.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/reviews/add")
  public String showAdd(Model model) {
    userInSession(model);
    model.addAttribute("bodyContent", "add-review");
    return "master-template";
  }

  /**
   * Method to edit a review.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/reviews/{id}/edit")
  public String showEdit(@PathVariable Long id,
                         Model model) {
    Review r = reviewService.findById(id);
    model.addAttribute("review", r);
    model.addAttribute("bodyContent", "add-review");
    return "master-template";
  }

  /**
   * Method to post a review.
   *
   * @param text String
   * @param userId Long
   * @return String
   */
  @PostMapping("/reviews")
  public String postReview(@RequestParam(required = false) String description,@RequestParam(required = false) Integer rating,
                           Model model) {
    User user = userInSession(model);
    reviewService.create(description, user, Double.valueOf(rating));
    return "redirect:/reviews";
  }

  /**
   * Method to update a review.
   *
   * @param id Long
   * @param text String
   * @param userId Long
   * @return String
   */
  @PostMapping("/reviews/{id}")
  public String updateReview(@PathVariable Long id,
                             @RequestParam(required = false) String text,
                             @RequestParam(required = false) Long userId) {
    User u = userService.findById(userId);
    reviewService.update(id, text, u);
    return "redirect:/reviews";
  }

  /**
   * Method to delete a review.
   *
   * @param id Long
   * @return String
   */
  @PostMapping("/reviews/{id}/delete")
  public String deleteReview(@PathVariable Long id) {
    reviewService.delete(id);
    return "redirect:/reviews";
  }

  /**
   * Method to get the register page.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/register")
  public String getRegisterPage(Model model) {
    model.addAttribute("bodyContent", "register");
    return "master-template";
  }

  /**
   * Method to register a user.
   *
   * @param username String
   * @param email String
   * @param password String
   * @param repeatPassword String
   * @param firstName String
   * @param lastName String
   * @param model Model
   * @return String
   */
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
  @GetMapping("/find")
  public String find(Model model){
    userInSession(model);
    model.addAttribute("bodyContent","find");
    return "master-template";
  }

  /**
   * Method to get the login page.
   *
   * @param model Model
   * @return String
   */
  @GetMapping("/login")
  public String getLoginPage(Model model) {
    model.addAttribute("bodyContent", "login");
    return "master-template";
  }

}
