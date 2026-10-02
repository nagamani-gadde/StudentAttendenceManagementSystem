package com.nit;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class StudentAttendenceManagementSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentAttendenceManagementSystem1Application.class, args);
	}
	
	

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http)
		        throws Exception {

		    return http
		            .csrf(csrf -> csrf.disable())
		            .authorizeHttpRequests(auth -> auth
		                    .requestMatchers(HttpMethod.POST, "/api/students").permitAll()
		                    .anyRequest().authenticated()
		            )
		            .httpBasic(Customizer.withDefaults())
		            .build();
		}

}
