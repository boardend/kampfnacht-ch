package ch.kampfnacht.web;

import java.util.Date;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ComponentScan("ch.kampfnacht.web")
public class RootRESTServiceController {
	
	@RequestMapping("/")
	protected String redirect() {
		// TODO: Find a way to display static files with ../app url only
		return "redirect:app/index.html";
	}

	@RequestMapping(value="/status")
	protected @ResponseBody AppStatus status() {
		final AppStatus status = new AppStatus();
		status.setTimestamp(new Date());
		return status;
	}

	private class AppStatus {
		private boolean running = true;
		private Date timestamp;

		@SuppressWarnings("unused")
		public boolean isRunning() {
			return running;
		}

		@SuppressWarnings("unused")
		public void setRunning(boolean running) {
			this.running = running;
		}

		@SuppressWarnings("unused")
		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
	}
}