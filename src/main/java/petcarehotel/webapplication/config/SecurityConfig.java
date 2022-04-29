package petcarehotel.webapplication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import petcarehotel.webapplication.models.enumerations.Role;

/**
 * Security configuration.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;
  private final CustomAuthenticationProvider customAuthenticationProvider;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/h2/**");
  }

  /**
   * Configuration for the user.
   *
   * @param http HttpSecurity
   * @throws Exception exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/","/money2.jpg","/vet.jpg","/vet2.jpg","/hotelll2.jpg","/hotelll.jpg","/friz2.jpg","/friz.jpg","/money.jpg","/money.png","/DDC_2.png","/DDC_1.png","/petker.png","/fiki.png", "/register", "/registration", "/registration/confirm").permitAll()
        .antMatchers("/gallery", "/reviews").hasAuthority(Role.ROLE_USER.name())
        //.antMatchers("/reviews").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login").permitAll()
        // .loginProcessingUrl("/loginn")
        .failureUrl("/login?error=BadCredentials")
        .defaultSuccessUrl("/")
        .and()
        .logout()
        .logoutUrl("/logout")
        .clearAuthentication(true)
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .logoutSuccessUrl("/");


  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(customAuthenticationProvider);
  }
}
