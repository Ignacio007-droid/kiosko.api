package com.kiosko.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner test(DataSource dataSource) {
		return args -> {
			try (Connection conexion = dataSource.getConnection()) {
				System.out.println("Conectado paa a la base de datos : " + conexion.getMetaData().getURL());
			} catch (Exception e) {
				System.err.println("Error lpm: " + e.getMessage());
			}
		};
	}
	/*
	@Bean
	public CommandLineRunner aniade(ProductoRepository repo) {
		return args -> {
			Producto p1 = new Producto();
			repo.save(p1);
			System.out.println("Producto insertado : "+p1.getNombre());
		};
	} */
}