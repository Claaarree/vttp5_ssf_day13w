package sg.edu.nus.iss.vttp5a_ssf_day13w;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.vttp5a_ssf_day13w.utils.Utility;

@SpringBootApplication
public class Vttp5aSsfDay13wApplication {

	public static void main(String[] args) {
		// SpringApplication.run(Vttp5aSsfDay13wApplication.class, args);
		// Uncomment below for task 1 (rmb to comment top)
		SpringApplication app = new SpringApplication(Vttp5aSsfDay13wApplication.class);
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);

		if(appArgs.containsOption("dataDir")){
			System.out.println("in data dir");
			// java myapp.jar --dataDir /opt/tmp/data
			// what to do about the space?
			// need a = between --dataDir and the arg to do this...
			String dataDir = appArgs.getOptionValues("dataDir").get(0);
			System.out.println(dataDir);
			Utility.dataDir= dataDir;

			// File dataDirFile = new File(dataDir);
			// System.out.println(dataDirFile.getAbsolutePath());
			// if (!dataDirFile.exists()){
			// 	System.out.println("in make directories");
			// 	System.out.println(dataDirFile.mkdirs());
			// 	// dataDirFile.mkdirs();
			// }
		
		} else{
			System.out.println("Usage: java -jar target/vttp5a-ssf-day13w-0.0.1-SNAPSHOT.jar --dataDir=src/main/resources/data");
			System.out.println("Please specify the data directory file path!");
			System.exit(1);
		}

		app.run(args);
	}

}
