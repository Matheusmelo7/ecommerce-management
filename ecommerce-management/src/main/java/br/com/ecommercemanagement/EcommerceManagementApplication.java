package br.com.ecommercemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(scanBasePackages = "br.com.ecommercemanagement")
public class EcommerceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceManagementApplication.class, args);
	}

}
