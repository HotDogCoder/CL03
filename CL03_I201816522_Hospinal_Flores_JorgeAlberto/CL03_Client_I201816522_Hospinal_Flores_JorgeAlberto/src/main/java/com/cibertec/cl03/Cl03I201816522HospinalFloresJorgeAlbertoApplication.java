package com.cibertec.cl03;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cibertec.poyo.User;

@SpringBootApplication
public class Cl03I201816522HospinalFloresJorgeAlbertoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Cl03I201816522HospinalFloresJorgeAlbertoApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		getAll();
		post();
		put();
		getLast();
		delete();
	}
	
	public void getAll() {
		RestTemplate template = new RestTemplate();
		String resultado = template.getForObject("http://localhost:8080/user", String.class);
		System.out.println("GET ALL: "+ resultado);
	}
	
	public void post() throws Exception {
		RestTemplate template = new RestTemplate();
		URI uri = new URI("http://localhost:8080/user");
		User user = new User(null, "juan@gmail.com", "Juan", "Garnizo", "3124", "juan.jpg" ,"juang");
		
		HttpHeaders header = new HttpHeaders();
		HttpEntity<User> request = new HttpEntity<User>(user, header);
		
		ResponseEntity<String> resultado = template.postForEntity(uri, request, String.class);
		
		System.out.println("POST: "+ resultado);
	}
	
	public void put() {

        RestTemplate template = new RestTemplate();
		Map <String, Integer> params = new HashMap <String, Integer> ();
        params.put("id", 2);
        User user = new User(null, "juan@gmail.com", "Juancito", "Garnizo", "31245", "juan.jpg" ,"juang");
        
        String url = "http://localhost:8080/user/{id}";
        template.put(url, user, params);
	}
	
	public void getLast() {
		RestTemplate template = new RestTemplate();
		String resultado = template.getForObject("http://localhost:8080/lastUser", String.class);
		System.out.println("GET LAST: "+ resultado);
	}
	
	public void delete() throws Exception {
		RestTemplate template = new RestTemplate();
		Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", 2);
        
		String url = "http://localhost:8080/user/{id}";
		String resultado = template.getForObject(url,String.class,params);
	    template.delete(url,params);
	    
	    System.out.println("Eliminado" + resultado);
	}

}
