package ch.kampfnacht;

import static org.springframework.boot.ansi.AnsiElement.GREEN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;

@EnableAutoConfiguration
@ComponentScan
public class KampfnachtApp extends SpringApplication {

	public static void main(String[] args) throws Exception {
		KampfnachtApp app = new KampfnachtApp(KampfnachtApp.class);
		app.run(args);
	}

	public KampfnachtApp() {
		super();
	}

	public KampfnachtApp(Class<KampfnachtApp> source) {
		super(source);
	}

	@Override
	protected void printBanner() {
		System.out.println("\n"
				+ AnsiOutput.toString(GREEN,
						StringUtils.arrayToDelimitedString(BANNER, ""))
				+ "(@Version 0.0.2, SpringBoot 0.5.5) \n\n");
	}

	private static String[] BANNER = {
			" .-.                          .--.                  .-.   .-.         .-.\n",
			" : :.-.                      : .-'                  : :  .' `.        : :\n",
			" : `'.' .--.  ,-.,-.,-..---. : `;,-.,-. .--.   .--. : `-.`. .'   .--. : `-.\n",
			" : . `.' .; ; : ,. ,. :: .; `: : : ,. :' .; ; '  ..': .. :: : _ '  ..': .. :\n",
			" :_;:_;`.__,_;:_;:_;:_;: ._.':_; :_;:_;`.__,_;`.__.':_;:_;:_;:_;`.__.':_;:_;\n",
			"                       : :\n",
			"                       :_;       ", };
}