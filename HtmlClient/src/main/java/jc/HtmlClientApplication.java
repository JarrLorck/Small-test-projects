package jc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class HtmlClientApplication {

	@Autowired
	InternalHttpClient internalHttpClient;

	@PostConstruct
	public void start() throws IOException {
		internalHttpClient.parsePage();
	}

	public static void main(String[] args) {
		SpringApplication.run(HtmlClientApplication.class, args);
	}
}
