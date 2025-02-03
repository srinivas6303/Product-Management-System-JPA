package com.example.PMS_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class PmsJpaApplication {

	public static void main(String[] args) {
		// Initialize Spring Application Context
		ApplicationContext context = SpringApplication.run(PmsJpaApplication.class, args);

		// Get the ProductServices bean
		ProductServices ps = context.getBean(ProductServices.class);

		// Adding sample products (Uncomment if needed)
		// ps.addProduct(new Product("ThinkPad", "Laptop", "Home", 2024));
		// ps.addProduct(new Product("Vivo 13", "Mobile", "Office", 2029));
		// ps.addProduct(new Product("Dell", "Laptop", "Home", 2025));
		// ps.addProduct(new Product("Realme Xt", "Mobile", "Office", 2030));

		// Display all products
		ps.getAllProducts();
		System.out.println("------------------------------------------------");

		// Fetch product by name
		ps.getProductByName("realme xt");
		System.out.println("------------------------------------------------");

		// Fetch products by place
		ps.getProductByPlace("office");
		System.out.println("------------------------------------------------");

		// Delete a product by name and check if it's deleted
		ps.deleteProductByName("dell");
		ps.getProductByName("dell");
		System.out.println("------------------------------------------------");

		// Check for products that are out of warranty
		ps.outOfWarrenty(2026);
		System.out.println("------------------------------------------------");

		// Find products by substring match
		ps.findBySubString("me");
		System.out.println("------------------------------------------------");

		// Delete all products and verify deletion
		ps.deleteAllProducts();
		ps.getAllProducts();
		System.out.println("------------------------------------------------");

		// Wait for user input before exiting
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to exit...");
		scanner.nextLine();
		scanner.close();
	}
}
