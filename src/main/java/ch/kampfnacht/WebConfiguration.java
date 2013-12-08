package ch.kampfnacht;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// static "webroot"-files
		registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
		registry.addResourceHandler("/favicon.png").addResourceLocations("/favicon.png");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
		registry.addResourceHandler("/apple-touch-icon-144x144-precomposed.png").addResourceLocations("/apple-touch-icon-144x144-precomposed.png");
		registry.addResourceHandler("/apple-touch-icon-57x57-precomposed.png").addResourceLocations("/apple-touch-icon-57x57-precomposed.png");
		registry.addResourceHandler("/apple-touch-icon-72x72-precomposed.png").addResourceLocations("/apple-touch-icon-72x72-precomposed.png");
		registry.addResourceHandler("/apple-touch-icon-precomposed.png").addResourceLocations("/apple-touch-icon-precomposed.png");
		// webapp (brunch build)
		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
		registry.addResourceHandler("/app").addResourceLocations("/app/index.html");
	}

}
