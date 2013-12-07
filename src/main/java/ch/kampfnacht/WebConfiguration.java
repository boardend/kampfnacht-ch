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
		//static "webroot"-files
		registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
		//TODO: add favicon
		
		//webapp
		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
		registry.addResourceHandler("/app").addResourceLocations("/app/index.html");
	}

}
