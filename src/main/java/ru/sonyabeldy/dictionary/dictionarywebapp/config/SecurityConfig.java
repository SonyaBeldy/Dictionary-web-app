package ru.sonyabeldy.dictionary.dictionarywebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//@EnableWebMvc
public class SecurityConfig {

    private final AuthProvider authProvider;

    public SecurityConfig(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeHttpRequests((auth) -> auth
//                                .requestMatchers("/dictionary").hasRole("USER")
//                                .requestMatchers("/login", "/auth/registration", "/error").permitAll()
//                                .anyRequest().permitAll()
//                        .requestMatchers("/auth/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("/user").hasRole("USER")
//                        .requestMatchers("/login", "auth/registration", "/error").permitAll() //любой пользователь, дане не аутентифицированный, сможет зайти на эти странички
//                        .anyRequest().hasAnyRole("USER", "ADMIN") //для всех остальных страничек даем достум юзеру и админу
                        .anyRequest().authenticated()

                ).formLogin(withDefaults())
                .httpBasic(withDefaults());;



//                .and()
//                .formLogin().loginPage("/auth/login")
//                .loginProcessingUrl("/process_login")
//                .defaultSuccessUrl("/hello", true)
//                .failureUrl("/auth/login?error")
//                .permitAll()
//                .and()
//                .logout().logoutUrl("/logout")
//                .logoutSuccessUrl("/auth/login");

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
