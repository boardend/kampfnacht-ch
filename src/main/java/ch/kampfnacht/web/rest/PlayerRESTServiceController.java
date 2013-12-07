package ch.kampfnacht.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.kampfnacht.model.Player;

@Controller
@RequestMapping("/rest/player")
public class PlayerRESTServiceController {

	@RequestMapping("")
	@ResponseBody
	protected List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.add(new Player());
		return players;
	}
}