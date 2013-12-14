package ch.kampfnacht;

import java.util.List;

import javax.servlet.Filter;

import org.eclipse.jetty.servlets.GzipFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
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

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(
				MediaType.APPLICATION_JSON);
	}
	
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
    }
	
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.addUrlPatterns("*");
		filterRegistration.setFilter(new GzipFilter());
		System.out.println("was in");
		return filterRegistration;
	}

}
