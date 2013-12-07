package ch.kampfnacht;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

	@Value("${port:8080}")
	private int port;

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		return new JettyEmbeddedServletContainerFactory(this.port);
	}
}
