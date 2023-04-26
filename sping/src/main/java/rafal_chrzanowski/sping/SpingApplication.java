package rafal_chrzanowski.sping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingApplication.class, args);
	}

}
