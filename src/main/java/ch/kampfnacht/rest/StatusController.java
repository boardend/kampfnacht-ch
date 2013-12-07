package ch.kampfnacht.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class StatusController {

	@RequestMapping("status")
	@ResponseBody
	protected String redirect() 
	{
	    return "ye";
	}
}