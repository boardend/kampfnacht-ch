package ch.kampfnacht.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootRESTServiceController {

	@RequestMapping("/status")
	@ResponseBody
	protected String status() 
	{
		// provide useful information
	    return "Up and running!";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	protected String login() 
	{
	    return "false";
	}
}