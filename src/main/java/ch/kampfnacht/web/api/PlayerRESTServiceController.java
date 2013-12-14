package ch.kampfnacht.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.kampfnacht.model.Player;
import ch.kampfnacht.model.db.security.Credential;
import ch.kampfnacht.service.db.security.CredentialService;

@Controller
@RequestMapping("/api")
public class PlayerRESTServiceController {
	
	private final CredentialService credentialService;

	@Autowired
	public PlayerRESTServiceController(CredentialService credentialService) {
		this.credentialService = credentialService;
	}

	@RequestMapping("player")
	@ResponseBody
	protected List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player());
		return players;
	}
	
	@RequestMapping("jpa")
	@ResponseBody
	protected boolean jpaTest() {
		final String testUsername = "testUsername";
		final String testPassword = "testPassword";
		credentialService.addCredential(testUsername, testPassword);
		Credential credential = credentialService.getCredential(testUsername); 
		return (testPassword.equals(credential.getPassword()));
	}
}