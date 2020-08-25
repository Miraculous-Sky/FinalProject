package root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN");
		//
		http.authorizeRequests().and().formLogin().loginPage("/login");
		http.authorizeRequests().and().formLogin().usernameParameter("email");
		http.authorizeRequests().and().formLogin().passwordParameter("password");
		http.authorizeRequests().and().formLogin().defaultSuccessUrl("/");
		http.authorizeRequests().and().formLogin().failureUrl("/login?error");
		http.authorizeRequests().and().formLogin().and().exceptionHandling().accessDeniedPage("/403");
//
	}
}
