package com.example.backend.backend;

import com.example.backend.Main;
import org.springframework.boot.SpringApplication;

public class TestBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(Main::main).with(TestcontainersConfiguration.class).run(args);
	}

}
