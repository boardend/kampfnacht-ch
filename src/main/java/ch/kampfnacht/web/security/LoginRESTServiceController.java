package ch.kampfnacht.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginRESTServiceController {
	
	@RequestMapping("/login")
	@ResponseBody
	protected String login() 
	{
	    return "false";
	}
}