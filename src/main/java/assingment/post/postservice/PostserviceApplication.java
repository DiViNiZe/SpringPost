package assingment.post.postservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PostserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostserviceApplication.class, args);
	}
}
