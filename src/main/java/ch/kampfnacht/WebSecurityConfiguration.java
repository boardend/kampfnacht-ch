package ch.kampfnacht;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Bean
	public AppWebSecurity applicationSecurity() {
		return new AppWebSecurity();
	}

	protected static class AppWebSecurity extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
	        http
            .authorizeRequests()
                .antMatchers("/mvc/blog/**").hasRole("ADMIN")
                .antMatchers("/mvc/blog").permitAll()
                .antMatchers("/mvc/rest/*").permitAll()
                .antMatchers("/mvc/status", "/mvc/status.txt").permitAll()
            .and()
                .formLogin()
                    .loginPage("/mvc/auth/login")
                    .defaultSuccessUrl("/mvc/blog/posts")
                    .failureUrl("/mvc/auth/login")
                    .usernameParameter("user")
                    .passwordParameter("pwd")
                    .permitAll()
            .and()
                .logout()
                    .logoutUrl("/mvc/auth/logout")
                    .logoutSuccessUrl("/mvc/blog")
                    .permitAll();
		}
		
		@Override
		public void configure(WebSecurity builder) throws Exception {
			builder.ignoring().antMatchers("/app**");
		}
	}
}
