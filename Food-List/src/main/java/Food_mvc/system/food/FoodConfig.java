package Food_mvc.system.food;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodConfig {
	@Bean // To create a bean,it needs a No arg constructor in the Student Class
	CommandLineRunner commandLineRunner(FoodRepository repository) {
		return args -> {
			Food carrot = new Food("carrot",300L);
			Food tomato = new Food("tomato",400L);
			
			repository.saveAll(List.of(carrot,tomato));	// Saving to the DB
		};
		
		
	}
}
