package learn.academics.springbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
@EnableAsync
public class SpringBatchApplicationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplicationDemoApplication.class, args);
		System.out.println("+++++Application started successfully");
	}

}
