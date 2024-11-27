package br.com.ecommercemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.ecommercemanagement")
public class EcommerceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceManagementApplication.class, args);
	}

}
