package wiktorkaminski.basicinvoiceapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    @Qualifier("UserRepositoryUserDetailsService")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .authoritiesByUsernameQuery(
                        "SELECT username, authority from users WHERE username = ?"
                )
                .passwordEncoder(new SCryptPasswordEncoder());
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(encoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/contractor/**", "/invoice/**", "/dashboard/**")
                .hasRole("USER")
                .antMatchers("/", "/**").permitAll();
    }
}
