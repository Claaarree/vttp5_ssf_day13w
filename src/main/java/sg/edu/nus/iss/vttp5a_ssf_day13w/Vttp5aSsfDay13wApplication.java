package sg.edu.nus.iss.vttp5a_ssf_day13w;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vttp5aSsfDay13wApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Vttp5aSsfDay13wApplication.class, args);
		SpringApplication app = new SpringApplication(Vttp5aSsfDay13wApplication.class);
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);

		if(appArgs.containsOption("dataDir")){
			// java myapp.jar --dataDir /opt/tmp/data
			// what to do about the space?
			// need a = between --dataDir and the arg to do this...
			String dataDir = appArgs.getOptionValues("dataDir").get(0);
		} else{
			System.out.println("Please specify the data directory file path!");
			System.exit(1);
		}

		app.run(args);
	}

}
