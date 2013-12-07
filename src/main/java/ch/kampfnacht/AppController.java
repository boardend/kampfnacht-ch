package ch.kampfnacht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class AppController {

	@RequestMapping("/")
	protected String redirect() {
		// TODO: Find a way to display static files with ../app url only
		return "redirect:app/index.html";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(AppController.class);
		app.run(args);
	}
}